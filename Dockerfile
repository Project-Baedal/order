FROM openjdk:21-jdk-slim
COPY build/libs/order-0.0.1-SNAPSHOT.jar order.jar
ENV TZ=Asia/Seoul
ENTRYPOINT ["java", "-jar", "order.jar"]