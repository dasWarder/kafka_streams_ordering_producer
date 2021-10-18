FROM maven:3.8.3-openjdk-11-slim
COPY ./ ./home/mvn
RUN mvn clean install -Dmaven.test.skip=true

FROM openjdk:11-jdk-slim
ARG PACKAGE=/target/*.jar
COPY $PACKAGE /producer.jar

ENTRYPOINT ["java", "-jar", "/producer.jar"]

