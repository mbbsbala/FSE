FROM tomcat:8.5-alpine
CMD ["catalina.sh", "run"]
COPY target/docker-spring-boot.war /usr/local/tomcat/webapps/app.war
RUN sh -c 'touch /usr/local/tomcat/webapps/app.war'
ENTRYPOINT ["sh", "-c", "java -Djava.security.egd=file:/dev/./urandom -jar /usr/local/tomcat/webapps/app.war"]

# tell docker what port to expose
EXPOSE 8082

