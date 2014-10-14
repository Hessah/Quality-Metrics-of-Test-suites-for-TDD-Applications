#!/bin/bash 
# Written by: Hessah Alkaoud
# it will go through all the benchmarks and redo the experiment to generate the mutation analysis metric.

# trove
for i in 1
do
cd trove-3.0.3/3.0.3/ 
sh ./run_major.sh
cd ../..
done

# commons-lang
for i in 1
do
cd commons-lang3-3.3.2-src/ 
sh ./run_major.sh
cd ..
done

# commons-io
for i in 1
do
cd commons-io-2.4-src/
sh ./run_major.sh
cd ..
done

# Jdom
for i in 1
do
cd jdom-JDOM-2.0.6/
sh ./run_major.sh
cd ..
done

# Numerics4j
for i in 1
do
cd numerics4j-1.2/
sh ./run_major.sh
cd ..
done

# jaxen
for i in 1
do
cd jaxen/
sh ./run_major.sh
cd ..
done

# lavalamp
for i in 1
do
cd lavalamp/
sh ./run_major.sh
cd ..
done

# netweaver
for i in 1
do
cd netweaver/
sh ./run_major.sh
cd ..
done



#for i in 1
#do
#cd commons-math3-3.2-src/ 
#sh ./run_major.sh
#cd ..
#done


# ------------------------------------TDD programs ---------------------

# Helium
for i in 1
do
cd TDD/Helium/
sh ./run_major.sh
cd ../..
done

# tyburn
for i in 1
do
cd TDD/tyburn/trunk/
sh ./run_major.sh
cd ../../..
done

# jbehave-core
for i in 1
do
cd TDD/jbehave-core-jbehave-3.9/jbehave-core/ 
sh ./run_major.sh
cd ../../..
done




