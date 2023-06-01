FROM openjdk:21
MAINTAINER baeldung.com
COPY target/gordao-0.0.1-SNAPSHOT.jar gordao-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/gordao-0.0.1-SNAPSHOT.jar"]