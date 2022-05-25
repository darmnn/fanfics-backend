FROM openjdk:11
VOLUME /tmp
EXPOSE 8080
ADD target/fanfics-backend-0.0.1-SNAPSHOT.jar fanfics-backend-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/fanfics-backend-0.0.1-SNAPSHOT.jar"]