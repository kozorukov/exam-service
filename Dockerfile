FROM maven:3.9.9-amazoncorretto-21-debian-bookworm
WORKDIR /opt
COPY . ./
RUN mvn clean package -DskipTests
ENTRYPOINT java -Dspring.profiles.active=docker -jar target/profid-1.0-SNAPSHOT.jar
