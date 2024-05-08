# Білд бекенду з Maven
FROM maven:3.8.4-openjdk-17 as backend-build
WORKDIR /app
COPY . /app
RUN mvn clean package -DskipTests

# Білд фронтенду з Node.js
FROM node:14 as frontend-build
WORKDIR /app
COPY frontend /app
RUN npm install
RUN npm run build

# Фінальне зображення
FROM openjdk:17
COPY --from=backend-build /app/target/*.jar /app/app.jar
COPY --from=frontend-build /app/build /app/public
WORKDIR /app
CMD ["java", "-jar", "app.jar"]