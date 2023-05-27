FROM amazoncorretto:17.0.6-alpine3.17
ENV APP_NAME=demo-jar-with-dependencies.jar
WORKDIR /app
COPY ${APP_NAME} /app
RUN echo $APP_NAME && ls -ah
CMD java -jar $APP_NAME