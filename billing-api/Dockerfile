FROM gradle:4.2.1-jdk8-alpine AS build-env

WORKDIR /home/gradle
ADD src /home/gradle/src
COPY ./build.gradle /home/gradle

RUN gradle build --stacktrace

FROM openjdk:8-jre-alpine
COPY --from=build-env /home/gradle/build/libs/gradle.jar /app/app.jar
EXPOSE 4000
CMD java -Djava.security.egd=file:/dev/./urandom $JAVA_OPTIONS -jar /app/app.jar