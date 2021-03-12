FROM frolvlad/alpine-oraclejre8:slim

RUN sh -c 'touch blog-1.0.0.jar'
ENV JAVA_OPTS=""

VOLUME /tmp
VOLUME /log

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /home/ec2-user/blog/blog-1.0.0.jar"]