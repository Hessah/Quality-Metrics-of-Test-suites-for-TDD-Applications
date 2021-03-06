#!/bin/sh
# By: Hessah Alkaoud

mkdir -p "javaNCSSReports"

sourceDir="src/main/java/"
testDir= "src/test/java/"

javancss -ncss $sourceDir -out SLOC.txt
javancss -ncss $testDir -out TLOC.txt
javancss -ncss $sourceDir $testDir -out KLOC.txt
javancss -function $sourceDir -out CCN.txt
javancss -package $testDir -out ./javaNCSSReports/#TestClasses.txt

mv SLOC.txt TLOC.txt KLOC.txt CCN.txt '#TestClasses.txt' "javaNCSSReports"
