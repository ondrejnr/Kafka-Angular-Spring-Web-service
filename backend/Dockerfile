FROM maven:3.9.5-eclipse-temurin-17 AS build
WORKDIR /app
# This line breaks the cache to ensure new dependencies are downloaded
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
# Added a dummy env to force K8s to pull fresh
ENV REBUILD_DATE=2026-02-23:13:20:59
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
