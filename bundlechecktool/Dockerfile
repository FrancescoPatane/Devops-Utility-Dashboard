#FROM openjdk:8-jdk-alpine 
FROM openjdk:8-jre
ARG JAR_FILE=target/*.jar 
COPY ${JAR_FILE} bundlechecktool-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/bundlechecktool-0.0.1-SNAPSHOT.jar"] 