FROM openjdk:17-jdk-alpine 
ARG JAR_FILE=target/*.jar 
COPY target/demo.DB-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
CMD ["java","-jar","/app.jar"]
