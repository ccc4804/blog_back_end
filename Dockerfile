FROM frolvlad/alpine-oraclejre8:slim

LABEL maintainer='ccc4804@gmail.com'

VOLUME /blog

ARG JAR_FILE=blog-1.0.0.jar

ADD ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]