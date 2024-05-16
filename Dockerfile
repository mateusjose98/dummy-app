# use the official maven image as the base image
FROM maven:3.8.3-openjdk-17-slim AS build

# set the working directory in the container
WORKDIR /app

# copy the project files to the working directory
COPY . .

# build the project
RUN mvn clean package -DskipTests=true

# use the official openjdk image as the base image
FROM openjdk:17-slim

# set the working directory in the container

WORKDIR /app

# copy the jar file from the build image to the working directory

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
# run the jar file

CMD ["java", "-jar", "app.jar"]