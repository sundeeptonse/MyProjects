#!/bin/sh
# -gc -t <pid> <interval(ms)> iterations

$JAVA_HOME=''
$LOG_LOCATION=''
if [ $# -lt 3 ]
then
   echo "Usage: $0 <pid> <interval(ms)> iterations"
   exit
fi

$JAVA_HOME/bin/jstat -gc -t $1 $2 $3 > $LOG_LOCATION/logs/jstat_$(hostname)_$1_$2_$3_$(date +%Y%m%d-%H%M%S).txt