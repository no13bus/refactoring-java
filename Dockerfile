# Build stage
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean test

# Optional: To build a runnable jar, uncomment the following line
# RUN mvn clean package