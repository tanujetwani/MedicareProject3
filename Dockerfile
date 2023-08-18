From openjdk:8
EXPOSE 8088
Add target/MedicareProject3-0.0.1-SNAPSHOT.war MedicareProject3-0.0.1-SNAPSHOT.war
ENTRYPOINT ["java","-jar","/MedicareProject3-0.0.1-SNAPSHOT.war"]