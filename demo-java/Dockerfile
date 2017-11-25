FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/demo-java-0.0.1-SNAPSHOT.jar /app.jar
EXPOSE 8090
CMD ["java","-jar","/app.jar"]
