#!/bin/sh
# By: Hessah Alkaoud
# purpose: to parase killed.csv and provide some statistics. 

# using: $ tr ' ' '\n' < FILE | grep WORD | wc -l
# Where tr replaces spaces with newlines, grep filters all resulting lines matching WORD and wc counts the remaining ones.

TIME=$(tr ' ' '\n' < killed.csv | grep TIME | wc -l)
EXC=$(tr ' ' '\n' < killed.csv | grep EXC | wc -l)
FAIL=$(tr ' ' '\n' < killed.csv | grep FAIL | wc -l)
LIVE=$(tr ' ' '\n' < killed.csv | grep LIVE | wc -l)

echo "TIME= "$TIME " ,EXC= "$EXC " ,FAIL= "$FAIL " ,LIVE= " $LIVE;

