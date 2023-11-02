# Use an image with Java 17 and Maven 3.8.x pre-installed
FROM maven:3.8.5-openjdk-17-slim

# Set the working directory in the container
WORKDIR /app

# Copy the project's pom.xml and src files to the container
COPY pom.xml .
COPY src ./src

# Build the application
RUN mvn package

# Use an official OpenJDK runtime with Java 17 that contains only the JAR file
FROM openjdk:17-alpine

# Copy the packaged JAR file into the container
COPY --from=build /app/target/java-crud-gh-actions-${app.version}.jar /app/java-crud-gh-actions.jar

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the JAR file
CMD ["java", "-jar", "/app/java-crud-gh-actions.jar"]
