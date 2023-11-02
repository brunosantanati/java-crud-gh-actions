# Use an image with Java 17 and Maven 3.8.x pre-installed
FROM maven:3.8.5-openjdk-17-slim

# Set the working directory in the container
WORKDIR /app

# Copy the project's pom.xml and src files to the container
COPY pom.xml .
COPY src ./src

# Build the application
RUN mvn package

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the JAR file
# TODO: come back here later to replace the hard-coded version with a variable app version
CMD ["java", "-jar", "/app/target/java-crud-gh-actions-1.0.0.jar"]
