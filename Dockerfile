# Use an official OpenJDK runtime as a parent image with Java 17
FROM openjdk:17-alpine

# Set the working directory to /app
WORKDIR /app

# Copy the packaged JAR file into the container
COPY target/java-crud-gh-actions-1.0.0.jar /app/java-crud-gh-actions-1.0.0.jar

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the JAR file
CMD ["java", "-jar", "java-crud-gh-actions-1.0.0.jar"]