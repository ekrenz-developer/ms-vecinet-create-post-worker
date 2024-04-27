FROM openjdk:21-jdk-buster

WORKDIR /app

# Puedes establecer valores predeterminados para las variables de entorno

COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src

RUN chmod +x ./gradlew
RUN ./gradlew build -x test --no-daemon

EXPOSE 8082

CMD ["java", "-jar", "build/libs/ms-vecinet-create-post-worker-0.0.1.jar"]