#!/bin/bash

SETTINGS="/Users/weasley/Development/program/apache-maven/conf/settings-sonatype.xml"
MODULE="dtt-spring-boot-3-x"

clear &&
  mvn clean package -pl :$MODULE -am --settings $SETTINGS
