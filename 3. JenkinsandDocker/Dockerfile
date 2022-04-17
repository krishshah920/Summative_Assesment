FROM maven:3.6.0-jdk-11-slim AS build
COPY pom.xml /home/app/pom.xml
RUN mvn -f /home/app/pom.xml verify clean --fail-never
COPY src /home/app/src
RUN mvn -f /home/app/pom.xml package
FROM tomcat:jdk8-openjdk
COPY --from=build /home/krishshah920/Documents/SummativeAssesment/Summitive_Assesment_Java.war /home/krishshah920/Applications/apache-tomcat-9.0.62/webapps/
EXPOSE 8080
