#!/bin/sh

echo "building the origional build_old.xml"
ant -buildfile build_old.xml clean compile.core compile.junit junit.nodeps


