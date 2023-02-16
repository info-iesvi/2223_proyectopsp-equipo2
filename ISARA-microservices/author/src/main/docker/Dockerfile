FROM openjdk:17
ADD isara_author-0.1.0.jar app.jar
EXPOSE 8083
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]