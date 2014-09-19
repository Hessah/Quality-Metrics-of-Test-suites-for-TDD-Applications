#!/bin/bash

#Files=./main/
# cd $Files
# pwd
#for f in $FILES 
#do
#echo "Processing $f"
#javac -XMutator:ALL -d bin "$f"
#done

#find ./main -name '*.java'| xargs javac -XMutator:ALL -d bin
#find "$1" -name "*.java"| while read $1; do echo $1 ; done

shopt -s globstar
javac -XMutator:ALL **/*.java
