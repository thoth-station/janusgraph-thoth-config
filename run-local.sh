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

[ -z "$SUDO_COMMAND" ] && exec sudo $0

set -x

which which > /dev/null
which buildah > /dev/null

JANUSGRAPH_VERSION="0.2.0-hadoop2"
JANUSGRAPH_WORKDIR="/opt/janusgraph-${JANUSGRAPH_VERSION}"

podman images | grep localhost/thoth-janusgraph -q || {
    echo "No localhost/thoth-janusgraph image found, build it using ./local-build.sh"
}

podman run -it -p 8182:8182 -v "${PWD}/scripts/:${JANUSGRAPH_WORKDIR}/scripts:Z" localhost/thoth-janusgraph
