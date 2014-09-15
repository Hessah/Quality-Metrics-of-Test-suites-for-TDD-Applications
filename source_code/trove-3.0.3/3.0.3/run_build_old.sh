#!/bin/sh

echo
echo "Compiling and mutating project"
echo
ant -buildfile build_old.xml clean compile test

