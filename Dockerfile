FROM openjdk:21

EXPOSE 8080
EXPOSE 8080
EXPOSE 9092
EXPOSE 27017
ADD target/journal.jar journal.jar
ENTRYPOINT ["java" , "-jar" , "journal.jar"]