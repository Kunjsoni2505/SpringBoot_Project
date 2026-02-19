# Use official OpenJDK image
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy Maven wrapper & pom first (for caching)
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn

# Download dependencies
RUN ./mvnw dependency:go-offline

# Copy the rest of the project
COPY src src

# Build the application
RUN ./mvnw clean package -DskipTests

# Expose port (Render injects PORT)
EXPOSE 8080

# Run the Spring Boot app
CMD ["sh", "-c", "java -jar target/*.jar"]
