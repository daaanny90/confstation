FROM openjdk:11-jdk-slim

LABEL organisation="Confgames.de"
LABEL author="Thomas Wünsche<thomas@ostec.de>"
LABEL version=0.1
LABEL description="Production Container to use In the GCP Universe"

RUN useradd confware

ARG jarPath=business/build/libs/business-0.0.1-SNAPSHOT.jar

COPY ${jarPath} /app/confware.jar

WORKDIR /app
EXPOSE 8080
USER confware:confware
CMD ["java", "-jar", "confware.jar"]
