#!/bin/bash

# ${BASH_SOURCE[0]} is the path to this file
SOURCE="${BASH_SOURCE[0]}"
# Set $BIN to the absolute, symlinkless path to $SOURCE's parent
while [ -h "$SOURCE" ]; do
    BIN="$( cd -P "$( dirname "$SOURCE" )" && pwd )"
    SOURCE="$(readlink "$SOURCE")"
    [[ $SOURCE != /* ]] && SOURCE="$BIN/$SOURCE"
done
BIN="$( cd -P "$( dirname "$SOURCE" )" && pwd )"
# Set $CFG to $BIN/../conf/gremlin-server
cd -P $BIN/../conf/gremlin-server
CFG=$(pwd)
# Set $LIB to $BIN/../lib
cd -P $BIN/../lib
LIB=$(pwd)
# Set $LIB to $BIN/../ext
cd -P $BIN/../ext
EXT=$(pwd)
# Initialize classpath to $CFG
CP="$CFG"
# Add the slf4j-log4j12 binding
CP="$CP":$(find -L $LIB -name 'slf4j-log4j12*.jar' | sort | tr '\n' ':')
# Add the jars in $BIN/../lib that start with "janusgraph"
CP="$CP":$(find -L $LIB -name 'janusgraph*.jar' | sort | tr '\n' ':')
# Add the remaining jars in $BIN/../lib.
CP="$CP":$(find -L $LIB -name '*.jar' \
                \! -name 'janusgraph*' \
                \! -name 'slf4j-log4j12*.jar' | sort | tr '\n' ':')
# Add the jars in $BIN/../ext (at any subdirectory depth)
CP="$CP":$(find -L $EXT -name '*.jar' | sort | tr '\n' ':')

# (Cygwin only) Use ; classpath separator and reformat paths for Windows ("C:\foo")
[[ $(uname) = CYGWIN* ]] && CP="$(cygpath -p -w "$CP")"

export CLASSPATH="${CLASSPATH:-}:$CP"

# Change to $BIN's parent
cd $BIN/..

export JANUSGRAPH_LOGDIR="$BIN/../log"

# Find Java
if [ "$JAVA_HOME" = "" ] ; then
    JAVA="java -server"
else
    JAVA="$JAVA_HOME/bin/java -server"
fi

# Set Java options
if [ "$JAVA_OPTIONS" = "" ] ; then
    JAVA_OPTIONS="-verbose:sizes -ea -XX:+CMSClassUnloadingEnabled -XX:+UseThreadPriorities -XX:ThreadPriorityPolicy=42 -Xms6144M -Xmx12288M -Xmn1024M -XX:+HeapDumpOnOutOfMemoryError -Xss256k -XX:StringTableSize=1000003 -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+CMSParallelRemarkEnabled -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1 -XX:CMSInitiatingOccupancyFraction=75 -XX:+UseCMSInitiatingOccupancyOnly -XX:+UseTLAB -XX:CompileCommandFile=/hotspot_compiler -XX:CMSWaitDuration=10000 -XX:+CMSParallelInitialMarkEnabled -XX:+CMSEdenChunksRecordAlways -XX:CMSWaitDuration=10000 -Djava.net.preferIPv4Stack=true -Dcassandra.jmx.local.port=7199 -XX:+DisableExplicitGC -javaagent:$LIB/jamm-0.3.0.jar -Dgremlin.io.kryoShimService=org.janusgraph.hadoop.serialize.JanusGraphKryoShimService"
fi

# Execute the application and return its exit code
set -x
if [ "$1" = "-i" ]; then
  shift
  exec $JAVA -Djanusgraph.logdir="$JANUSGRAPH_LOGDIR" -Dlog4j.configuration=conf/gremlin-server/log4j-server.properties $JAVA_OPTIONS -cp $CP:$CLASSPATH org.apache.tinkerpop.gremlin.server.util.GremlinServerInstall "$@"
else
  ARGS="$@"
  if [ $# = 0 ] ; then
    ARGS="conf/gremlin-server/gremlin-server.yaml"
  fi
  exec $JAVA -Djanusgraph.logdir="$JANUSGRAPH_LOGDIR" -Dlog4j.configuration=conf/gremlin-server/log4j-server.properties $JAVA_OPTIONS -cp $CP:$CLASSPATH org.apache.tinkerpop.gremlin.server.GremlinServer $ARGS
fi
