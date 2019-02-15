#!/bin/bash

set -ex

# Start the server and give it some warm-up time.
bin/thoth-gremlin-server.sh &

sleep 10

echo -e "\n\n>>>>Preparing schema...\n\n" 2>&1
bin/gremlin.sh -e scripts/thoth_schema_definition.groovy

echo -e "\n\n>>>>Preparing indexes...\n\n" 2>&1
for file in scripts/indeces/*.groovy; do
    bin/gremlin.sh -e $file
done

echo -e "\n\n>>>>Submitting reindex job...\n\n" 2>&1
bin/gremlin.sh -e scripts/submit-reindex-jobs.groovy
	

echo -e "\n\n>>>>Waiting for indexes to be propagated to cluster...\n\n" 2>&1
sleep 120
bin/gremlin.sh -e scripts/wait-for-indexes.yaml


echo "\t\t\tContainer is ready now... \o/" 2>&1

while :; do
  sleep 300
done
