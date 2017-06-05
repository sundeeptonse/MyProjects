mainscriptspec="${0}"
mainscriptfile="$(basename ${mainscriptspec})"
mainscriptname="${mainscriptfile%.*}"
wdir=$(dirname "${mainscriptspec}")
. $wdir/config.sh
logfile=$LOG_PATH/${mainscriptname}.log
