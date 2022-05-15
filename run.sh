#!/bin/bash
mvn compile
mvn exec:java -Dexec.mainClass="MainKt"
