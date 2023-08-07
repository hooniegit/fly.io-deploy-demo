FROM eclipse-temurin:17.0.8_7-jdk-ubi9-minimal

# VOLUME /tmp
# ARG JAR_FILE=target/*.jar
COPY build/libs/taitanic-user-api-2.1.0.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]