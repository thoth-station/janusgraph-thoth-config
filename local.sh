#!/bin/bash
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

function die() {
    echo "$*" 1>&2
    exit 1
}

function print_help() {
    echo -e "NAME:
    $0 - manipulate with Thoth's local JanusGraph instance

USAGE:

    $0 command

COMMANDS:

    all\t\tBuild, initialize and run JanusGraph server as one shot.
    build\tBuild raw JanusGraph without any schema and index configuration.
    clean\tClean all resources used.
    download\tDownload the upstream version of JanusGraph into a local directory.
    help\tShow this help and exit.
    init\tInitialize JanusGraph with the local copy of schema and index configuration (has to be run after build).
    rmi\t\tRemove initialized JanusGraph image.
    rm\t\tRemove initialized container.
    run\t\tRun the initialized image (has to be run after build and subsequent init).
    sh\t\tRun shell inside JanusGraph container.
    "
}

[[ -n "${VERBOSE}" ]] && set -x

which which > /dev/null || die "No which command found"
which podman > /dev/null || die "No podman command found"

source ./vars.sh

function do_init() {
    podman run -it -p 8182:8182 \
        -v "${PWD}/scripts/:${JANUSGRAPH_WORKDIR}/scripts:Z" \
        -v "${PWD}/bin/init.sh:${JANUSGRAPH_WORKDIR}/bin/init.sh:Z" \
        --entrypoint "${JANUSGRAPH_WORKDIR}/bin/init.sh" \
        --name thoth-janusgraph-local \
        localhost/thoth-janusgraph-noinit
    [[ $? -ne 0 ]] && {
        podman rm thoth-janusgraph-local 2>/dev/null
        die "JanusGraph failed to initialize properly..."
    }
    echo "Committing initialized container..."
    podman commit thoth-janusgraph-local localhost/thoth-janusgraph-init
    podman rm thoth-janusgraph-local
}

function do_run() {
    podman run -it -p 8182:8182 \
        -v "${PWD}/scripts/:${JANUSGRAPH_WORKDIR}/scripts:Z" \
        -v "${PWD}/bin/init.sh:${JANUSGRAPH_WORKDIR}/bin/init.sh:Z" \
        localhost/thoth-janusgraph-noinit
}

case $1 in
    "all")
	./build-local.sh
	do_init
	do_run
        ;;
    "init")
        shift
        do_init
        ;;
    "download")
        shift
        curl -L "https://github.com/JanusGraph/janusgraph/releases/download/v${JANUSGRAPH_VERSION_IDENTIFIER}/janusgraph-${JANUSGRAPH_VERSION}.zip" -o "janusgraph-${JANUSGRAPH_VERSION}.zip"
        unzip "janusgraph-${JANUSGRAPH_VERSION}.zip" && echo "Extracted JanusGraph present in ${PWD}"
        ;;
    "bash"|"sh")
        shift
        podman exec -it -p 8182:8182 \
            -v "${PWD}/scripts/:${JANUSGRAPH_WORKDIR}/scripts:Z" \
            -v "${PWD}/bin/init.sh:${JANUSGRAPH_WORKDIR}/bin/init.sh:Z" \
            --entrypoint "/bin/bash" \
            localhost/thoth-janusgraph-init
        ;;
    "rm")
        shift
        # We remove local in case of init failures.
        podman rm thoth-janusgraph thoth-janusgraph-local 2> /dev/null
        ;;
    "rmi")
        shift
        # We do not remove core container, remove it explicitly in clean.
        podman rmi localhost/thoth-janusgraph-init 2> /dev/null
        ;;
    "clean")
        shift
        podman rm thoth-janusgraph-local thoth-janusgraph 2> /dev/null
        podman rmi localhost/thoth-janusgraph-init localhost/thoth-janusgraph-noinit 2> /dev/null
        ;;
    "build")
        shift
        exec ./build-local.sh $@
        ;;
    "run")
        shift
	do_run
        ;;
    "help"|"--help"|*)
        shift
        print_help
        exit 0
        ;;
esac
