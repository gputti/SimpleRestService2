#!/bin/sh
export MAVEN_OPTS="-Xmx512M -XX:MaxPermSize=2048M"
mvn clean compile dependency:copy-dependencies -DexcludeScope=provided $* 
