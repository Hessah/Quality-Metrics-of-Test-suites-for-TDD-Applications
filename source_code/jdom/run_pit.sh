#!/bin/sh

echo "Compiling and mutating project using: PIT"
ant -buildfile build_old.xml prepare compile.core compile.junit junit.nodeps pit

