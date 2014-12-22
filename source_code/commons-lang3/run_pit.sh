#!/bin/sh

echo "Compiling and mutating project using: PIT"
ant -buildfile build_old.xml clean compile compile.tests pit

