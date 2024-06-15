FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY build/libs/Recetario-0.0.1-SNAPSHOT.jar /app/Recetario-0.0.1-SNAPSHOT.jar

EXPOSE 8080

CMD ["java", "-jar", "Recetario-0.0.1-SNAPSHOT.jar"]
