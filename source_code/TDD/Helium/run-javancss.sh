#!/bin/sh
# By: Hessah Alkaoud

mkdir -p "javaNCSSReports"

sourceDir="build/coverage/src"
testDir= "build/coverage/tests"

javancss -ncss $sourceDir -out SLOC.txt
javancss -ncss $testDir -out TLOC.txt
javancss -ncss $sourceDir $testDir -out KLOC.txt
javancss -function $sourceDir -out CCN.txt

mv SLOC.txt TLOC.txt KLOC.txt CCN.txt "javaNCSSReports"
