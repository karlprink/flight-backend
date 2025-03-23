FROM openjdk:17-jdk-slim

WORKDIR /app

COPY jar/flight-api-0.0.1.jar /app/flight-api-0.0.1.jar

EXPOSE 8080
ENV DB_USERNAME=admin
ENV DB_PASSWORD=admin

ENTRYPOINT ["java", "-jar", "flight-api-0.0.1.jar"]