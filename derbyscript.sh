#!/bin/sh
#set -x

startderby() {
    echo "starting ......"
    java -Xms512m -Xmx4096m -jar $DERBY_HOME/lib/derbyrun.jar server start -h 0.0.0.0 -p $DERBY_PORT -noSecurityManager &> /dev/null &
}

stopderby() {
    echo "stopping ....."
    java -jar $DERBY_HOME/lib/derbyrun.jar server shutdown -h 0.0.0.0 -p $DERBY_PORT  &> /dev/null
}


DERBY_PORT=1528
DERBY_SERVER="localhost:${DERBY_PORT}"
cd `dirname $0` > /dev/null || exit
HOME_DIR=$PWD
DERBY_HOME=$PWD/derby
export DERBY_OPTS='-Dij.database="jdbc:derby://'$DERBY_SERVER'/db;user=yaams;password=yaams;create=true"'
#echo $DERBY_OPTS

if [ $1 = "start" ]; then
    startderby;  
fi

if [ $1 = "stop" ]; then
    stopderby;    
fi

exit;