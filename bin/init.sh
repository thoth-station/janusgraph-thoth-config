#!/bin/bash

set -ex

BIN=${BIN:-bin}
SCRIPTS=${SCRIPTS:-scripts}
WAIT_FOREVER=${WAIT_FOREVER:-1}

function myecho() {
    echo -e "\n\n>>>> " $@ "\n\n"
}

# Start the server and give it some warm-up time.
${BIN}/thoth-gremlin-server.sh &

until nc -z localhost 8182
do
    myecho "Waiting for Gremlin server to become available..."
    sleep 1
done

myecho "Gremlin server is reachable now..."

myecho "Preparing schema and indexes..."
${BIN}/gremlin.sh -e "${SCRIPTS}/init.groovy"

myecho "Container is ready now... \o/" 2>&1

[[ "${WAIT_FOREVER}" -ne 0 ]] && sleep inf

exit 0
