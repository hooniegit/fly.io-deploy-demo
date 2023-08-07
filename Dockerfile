FROM eclipse-temurin:17-jdk-alpine

ARG VER
ENV STG=prd

COPY "build/libs/dmarioweb-${VER}.jar" app.jar

ENTRYPOINT ["java","-Dspring.profiles.active=${STG}", "-jar","/app.jar"]
