FROM openjdk:8
RUN mkdir app
ADD target/price-0.0.1-SNAPSHOT.jar app/docker-price-service.jar
WORKDIR app
RUN "pwd"
RUN "ls"
EXPOSE 8098
ENTRYPOINT ["java", "-jar", "docker-price-service.jar"]

