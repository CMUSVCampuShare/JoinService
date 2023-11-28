# Use a base image with JDK and a minimal OS
FROM openjdk

# Set the working directory in the container
WORKDIR /app

# Copy the Spring Boot application JAR file into the container
COPY build/libs/join-0.0.1-SNAPSHOT.jar /app/JoinService.jar

# Specify the command to run on container startup
CMD ["java", "-jar", "JoinService.jar"]