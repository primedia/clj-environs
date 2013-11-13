#!/bin/bash
mvn install:install-file -DgroupId=local -DartifactId=environs.core -Dversion=1.0.0 -Dpackaging=jar -Dfile=./target/environs-1.0.0.jar
