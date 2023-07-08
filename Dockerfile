FROM openjdk:17-jdk

WORKDIR /app
COPY target/hrms-0.0.1-SNAPSHOT.jar hrms.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "hrms.jar"]