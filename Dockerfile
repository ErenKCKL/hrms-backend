# AS <NAME> to name this stage as maven
FROM maven:3.6.3 AS maven
LABEL MAINTAINER="ernkckl09@gmail.com"

WORKDIR /usr/src/app
COPY . /usr/src/app
# Compile and package the application to an executable JAR
RUN mvn package