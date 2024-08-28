FROM adoptopenjdk/openjdk11:jre-11.0.6_10-alpine
ADD target/UserMicroservice-0.0.1-SNAPSHOT.jar app.jar
ADD target/ApiGateway-0.0.1-SNAPSHOT.jar app.jar
ADD target/BooksMicroservice-0.0.1-SNAPSHOT.jar app.jar
ADD target/ServiceRegister-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]