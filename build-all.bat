@echo off

call mvn package dockerfile:build -DskipTests -f ./configserver/pom.xml
call mvn package dockerfile:build -DskipTests -f ./eureka-discovery/pom.xml
call mvn package dockerfile:build -DskipTests -f ./parking/pom.xml
call mvn package dockerfile:build -DskipTests -f ./booking/pom.xml