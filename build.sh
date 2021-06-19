#!/bin/bash
set -e
command -v mvn > /dev/null 2>&1 || {
  echo "Did not find mvn in PATH. Assuming MAVEN is not installed"
	exit 1
}

cd IllegalAccessErrorC || exit
mvn clean install
cd ..
cd IllegalAccessErrorA || exit
mvn clean package
cd ..
cd IllegalAccessErrorB || exit
mvn clean package
