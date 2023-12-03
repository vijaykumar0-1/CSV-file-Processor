FROM gradle:7-jdk17 AS builder
COPY . .
RUN gradle build
FROM openjdk:17-slim
COPY --from=builder build/libs/userAuthentication-0.0.1-SNAPSHOT.jar CSVfileProcessor.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","CSVfileProcessor.jar"]
