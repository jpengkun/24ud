FROM openjdk:8-jdk-alpine
ADD *.jar app1.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app1.jar"]
ENV LANG C.UTF-8
