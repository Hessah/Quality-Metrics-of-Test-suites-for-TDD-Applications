#!/bin/sh

echo "Compiling and mutating project using: PIT"
ant -buildfile pit_build.xml clean java-classes test-classes pit
