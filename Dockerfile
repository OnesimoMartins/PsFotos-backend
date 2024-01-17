FROM openjdk:11
WORKDIR /PsFotos-backend
CMD ["./gradlew", "clean", "bootJar"]
COPY build/libs/*.jar app.jar
EXPOSE 2836
ENTRYPOINT ["java", "-jar", "/app.jar"]
