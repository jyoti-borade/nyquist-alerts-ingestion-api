# Stage 1: Build the application
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app

# Copy the pom.xml and download project dependencies
COPY pom.xml .
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Stage 2: Create the final image
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy the jar from the build stage
COPY --from=build /app/target/nyquist-alerts-ingestion-api-0.0.1-SNAPSHOT.jar /app/nyquist-alerts-ingestion-api.jar

# Expose the port the application runs on
EXPOSE 8080

# Set the default command to run the app
ENTRYPOINT ["java", "-jar", "/app/nyquist-alerts-ingestion-api.jar"]
