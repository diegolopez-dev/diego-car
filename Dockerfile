FROM maven:3-eclipse-temurin-17
COPY . .
RUN mvn clean package -DskipTest

FROM openjdk:17-alpine
COPY Diego-car/target/Diego-car-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]