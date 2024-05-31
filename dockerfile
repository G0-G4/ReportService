# Use the official Maven image as the base image
FROM maven:3.9-amazoncorretto-21-debian AS build

# Set the working directory
WORKDIR /app

# Clone the repository from GitHub
RUN apt-get update
RUN apt-get -y install git
RUN git clone --depth 1 https://github.com/G0-G4/ReportService.git .

# Build the application
RUN mvn clean package -Dmaven.test.skip=true

# Create a new image for running the application
FROM openjdk:22-ea-21-jdk-slim-bullseye

# Set the working directory
WORKDIR /app

# Copy the built JAR file from the previous stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port on which the Spring Boot application will run
EXPOSE 8080

# Command to run the application
CMD ["java", "-Dspring.profiles.active=dev","-jar", "app.jar"]


# docker build -t reporter .
#
# docker run --name rep -p 8080:8080 -e WILDBERRIES_TOKEN=%WILDBERRIES_TOKEN% reporter
#
# container start -p 8080:8080 -e WILDBERRIES_TOKEN=%WILDBERRIES_TOKEN% rep