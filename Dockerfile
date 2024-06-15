FROM openjdk:11

WORKDIR /app

COPY ..

RUN npm install

EXPOSE 3080

CMD ["java", "-jar", "Recetario-0.0.1-SNAPSHOT.jar"]
