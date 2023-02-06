# Use an official OpenJDK image as the base image
FROM openjdk:17-alpine

# Set the working directory
WORKDIR /app

# Copy the JAR file to the working directory
COPY target/*.jar app.jar

# Run the Spring Boot application
ENTRYPOINT ["java", "-Dspring.profiles.active=${PROFILE}","-jar", "app.jar"]
