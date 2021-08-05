FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} diagnostic-tool-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/diagnostic-tool-0.0.1-SNAPSHOT.jar"]