# Use Java 17
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copy Maven wrapper
COPY pom.xml .
COPY .mvn .mvn
COPY mvnw .
RUN chmod +x mvnw

# Download dependencies
RUN ./mvnw dependency:go-offline

# Copy source code
COPY src src

# Build the application
RUN ./mvnw clean package -DskipTests

# Expose port (Render listens on this)
EXPOSE 8080

# 🔑 IMPORTANT: use exact jar name
CMD ["java", "-jar", "target/flashkart-0.0.1-SNAPSHOT.jar"]
