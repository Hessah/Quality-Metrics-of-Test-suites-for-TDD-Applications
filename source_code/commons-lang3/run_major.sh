#!/bin/sh

echo "Compiling and mutating project using: MAJOR"
ant -DmutOp=":ALL" clean compile 
ant mutation-test

time_stamp=$(date +%Y_%m_%d_%H_%M_%S)
mkdir -p "majorReports/${time_stamp}"
mv mutants.log killed.csv results.csv "majorReports/${time_stamp}"
sleep 10;import -window root majorReports/${time_stamp}/${time_stamp}.png

