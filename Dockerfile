FROM openjdk:11
COPY "./target/simple-interest-docker.jar" "app.jar"
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]
