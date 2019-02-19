#!/bin/bash -xe
# Thoth's local JanusGraph build
# Copyright(C) 2019 Fridolin Pokorny
#
# This program is free software: you can redistribute it and / or modify
# it under the terms of the GNU General Public License as published by
# the Free Software Foundation, either version 3 of the License, or
# (at your option) any later version.
#
# This program is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
# GNU General Public License for more details.
#
# You should have received a copy of the GNU General Public License
# along with this program. If not, see <http://www.gnu.org/licenses/>.

source ./vars.sh

if ! type buildah; then
    dnf install -y --setopt=tsflags=nodocs buildah
fi

ctr=$(buildah from "fedora:29")
mnt=$(buildah mount $ctr)

## Install components.
buildah run $ctr -- ln -s /usr/bin/python3 /usr/bin/python
buildah run $ctr -- pip3 install ansible

# Cleanup.
buildah run $ctr -- dnf clean all
buildah run $ctr -- rm -Rf /root/.cache

# Setup user environment.
buildah run $ctr -- useradd -m user
mkdir -p "${mnt}/${JANUSGRAPH_WORKDIR}"
cp -r ansible/ "${mnt}/${JANUSGRAPH_WORKDIR}"

# Add ansible playbooks and explicitly set host to localhost.
echo  -e "[gremlin_servers]\nlocalhost\n" > "${mnt}/${JANUSGRAPH_WORKDIR}/ansible/hosts"
buildah run $ctr -- ansible-playbook --extra-vars "janusgraph_init=false" --connection=local "${JANUSGRAPH_WORKDIR}/ansible/provision.yaml" -i "${JANUSGRAPH_WORKDIR}/ansible/hosts"
rm -rf "${mnt}/${JANUSGRAPH_WORKDIR}/ansible"

buildah run $ctr -- chown user:user -R "${JANUSGRAPH_WORKDIR}"

## Include some buildtime annotations.
buildah config --annotation "ninja.thoth-station.build.host=$(uname -n)" $ctr
buildah config --author fridolin@redhat.com $ctr
buildah config --cmd "/bin/bash" $ctr
buildah config --workingdir "${JANUSGRAPH_WORKDIR}" $ctr
buildah config --user user $ctr

cp -r bin/init.sh "${mnt}/${JANUSGRAPH_WORKDIR}/bin/"
buildah config --entrypoint "${JANUSGRAPH_WORKDIR}/bin/thoth-gremlin-server.sh" $ctr

## Commit this container to an image name
buildah umount $ctr
cid=`buildah commit $ctr thoth-janusgraph-noinit`
buildah tag $cid localhost/thoth-janusgraph-noinit:latest
