FROM anapsix/alpine-java:8_server-jre_unlimited

LABEL maintainer="WangSongJun <songjun.wang@foxmail.com>"
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

WORKDIR /app

ENV JAVA_OPTS="-Dserver.port=8080"

ADD notification-biz/target/notification-biz-0.0.1-SNAPSHOT.jar /app/
CMD java ${JAVA_OPTS} -jar /app/notification-biz-0.0.1-SNAPSHOT.jar

EXPOSE 8080