# Etapa 1: build da aplicação com Gradle e JDK 21
FROM gradle:8.4.0-jdk21 AS build
WORKDIR /app
COPY . .
RUN chmod +x gradlew
RUN ./gradlew clean build -x test -x check

# Etapa 2: runtime com JRE 21 leve
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
