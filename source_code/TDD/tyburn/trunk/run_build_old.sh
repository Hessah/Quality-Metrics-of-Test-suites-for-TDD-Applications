#!/bin/sh


echo "building the origional build_old.xml"
ant -buildfile pit_build.xml clean java-classes test-classes successful-tests

