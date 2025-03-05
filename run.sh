clear
javac -cp "/opt/tomcat/lib/servlet-api.jar:/lib/mysql-connector-java-9.2.0.jar" -d build src/com/example/servlet/LoginServlet.java
sleep 1

cp build/com/example/servlet/LoginServlet.class WebContent/WEB-INF/classes/com/example/servlet/LoginServlet.class
sleep 1

/opt/tomcat/bin/shutdown.sh
sleep 1

rm -rf /opt/tomcat/webapps/my-servlet-app
rm -f /opt/tomcat/webapps/my-servlet-app.war
sleep 1

jar -cvf my-servlet-app.war -C WebContent/ .
sleep 1

mv my-servlet-app.war /opt/tomcat/webapps
sleep 1

/opt/tomcat/bin/startup.sh
