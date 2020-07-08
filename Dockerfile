FROM openjdk:8-jdk-alpine
RUN apk update
RUN apk add wget
ADD target/personality-test-*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
EXPOSE 8080
