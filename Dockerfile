# --- Build Stage ---
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app

# Copy the pom.xml and source code from the server directory
COPY server/pom.xml ./server/
COPY server/src ./server/src
COPY server/.mvn ./server/.mvn
COPY server/mvnw ./server/

# Fix line endings for mvnw if needed and build the application
RUN cd server && chmod +x mvnw && ./mvnw clean package -DskipTests

# --- Run Stage ---
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app

# Copy the built jar from the build stage
COPY --from=build /app/server/target/s-kart-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080 (standard for Spring Boot)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
