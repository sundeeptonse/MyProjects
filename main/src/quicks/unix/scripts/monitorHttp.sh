count=`ps -ef | grep "httpd" | wc -l`
echo $count >> ${log_file}