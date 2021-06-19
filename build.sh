#!/bin/bash

cd IllegalAccessErrorC || exit
mvn clean install
cd ..
cd IllegalAccessErrorA || exit
mvn clean package
cd ..
cd IllegalAccessErrorB || exit
mvn clean package
