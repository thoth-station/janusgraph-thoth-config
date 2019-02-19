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

myecho "Preparing schema..."
${BIN}/gremlin.sh -e "${SCRIPTS}/thoth_schema_definition.groovy"

myecho "Preparing indexes..."
for file in "${SCRIPTS}/indeces/"*.groovy; do
    ${BIN}/gremlin.sh -e "${file}"
done

myecho "Submitting reindex job..."
${BIN}/gremlin.sh -e "${SCRIPTS}/submit-reindex-jobs.groovy"
	

myecho "Waiting for indexes to be propagated to cluster..."
sleep 120
${BIN}/gremlin.sh -e "${SCRIPTS}/wait-for-indexes.yaml"


myecho "Container is ready now... \o/" 2>&1

[[ "${WAIT_FOREVER}" -eq 0 ]] && exit 0

while :; do
  sleep 300
done
