#!/bin/sh
# By: Hessah Alkaoud

ant -DmutOp=":ALL" compile mutation-test 

time_stamp=$(date +%Y_%m_%d_%H_%M_%S)
mkdir -p "majorReports/${time_stamp}"
mv mutants.log killed.csv results.csv "majorReports/${time_stamp}"
sleep 10;import -window root majorReports/${time_stamp}/${time_stamp}.png
echo "..............Calculated mutation score using: MAJOR .. Results are stored in: majorReports/ ................"
