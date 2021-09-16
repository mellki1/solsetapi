FROM openjdk:8
ADD target/solset-0.0.1-SNAPSHOT.jar solset-0.0.1-SNAPSHOT.jar
CMD java -jar solset-0.0.1-SNAPSHOT.jar
EXPOSE 8080
