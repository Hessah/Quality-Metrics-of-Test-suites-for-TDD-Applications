#!/bin/sh
# By: Hessah Alkaoud

echo ""
ant clean compile compile-tests jacoco.report

time_stamp=$(date +%Y_%m_%d_%H_%M_%S)
mkdir -p "jacocoAllReports/${time_stamp}"
mv jacocoReport "jacocoAllReports/${time_stamp}"
echo ".............. Calculated the coverage metrics using: Jacoco.. Results are stored in: jacocoAllReports/ ................"
