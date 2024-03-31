# Stage 1: Build the application (gradle)
FROM gradle:7.5.1-jdk17 AS builder

WORKDIR /app

#Assuming build.gradle & settings.gradle are present
COPY build.gradle settings.gradle ./

RUN gradle bootBuildImage -DskipTests=true  # Build image with Gradle task, skipping tests

# Stage 2: Slim runtime image
FROM adoptium/openjdk:17-slim

WORKDIR /app

 #Copy JAR from builder stage
COPY --from=builder /app/build/libs/*.jar /app

EXPOSE 8080

CMD [ "java", "-jar", "stall_rental_mamagement_api-0.0.1.jar" ]
