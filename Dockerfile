FROM openjdk:22-jdk-slim

ARG SERVICE_PATH=test_service
WORKDIR /app

RUN apt-get update && apt-get install -y curl

COPY ${SERVICE_PATH}/gradlew .
COPY ${SERVICE_PATH}/gradle/ gradle/

COPY ${SERVICE_PATH}/build.gradle .
COPY ${SERVICE_PATH}/settings.gradle .
COPY ${SERVICE_PATH}/src/ src/

RUN chmod +x gradlew

RUN ./gradlew build --no-daemon -x test

ARG JAR_FILE=build/libs/*.jar

RUN cp ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
