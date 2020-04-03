FROM maven:latest
WORKDIR /app
COPY . .
ENTRYPOINT ["mvn", "pom.xml package"]
