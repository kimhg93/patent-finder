FROM openjdk:11-jre-slim

ARG JAR_FILE=build/libs/patent-finder-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} app.jar

EXPOSE 80

ENV JASYPT_ENCRYPTOR_PASSWORD=""

ENTRYPOINT exec java -Djasypt.encryptor.password=${JASYPT_ENCRYPTOR_PASSWORD} -jar /app.jar

#nohup docker run -e JASYPT_ENCRYPTOR_PASSWORD=patent-finder-encrypt -p 80:80 patent-finder &