FROM openjdk:23-jdk-slim
WORKDIR /app
COPY target/*.jar app.jar
CMD ["java", "-jar", "/app/app.jar"]