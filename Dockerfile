FROM openjdk:17.0.1-jdk-slim
COPY build/libs/billingService-0.0.1-SNAPSHOT.jar /app/billingService.jar
EXPOSE 8001
CMD ["java", "-jar", "/app/billingService.jar"]