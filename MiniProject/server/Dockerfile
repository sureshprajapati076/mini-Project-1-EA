FROM openjdk:8
ADD target/demo-1-0.0.1-SNAPSHOT.jar demo-1-0.0.1-SNAPSHOT.jar
COPY /src/main/resources/users.csv /demo-1/src/main/resources/users.csv
EXPOSE 8085
ENTRYPOINT ["java","-jar","demo-1-0.0.1-SNAPSHOT.jar"]