# embeddedjetty9-spring4
Stub project: embedded Jetty 9, Spring 4 MVC, gradle 2

This project sets up a quick and dirty embedded Jetty server with Spring 4 MVC 
and gradle 2 as the build and dependency management agent. It provides:

 *  a couple of RESTful test endpoints to test the MVC functionality
 *  serves a static HTML page and simple JavaScript file to test static resources
 *  packages the project into a "fat jar" - an executable jar with all dependencies included

to build:
gradle fatJAR

to run:
java -jar embeddedjetty9-spring4-all-0.1.jar

to set up eclipse after pulling down this project:
gradle eclipse

to test the RESTful controllers:
http://localhost:8080/embeddedTestString
http://localhost:8080/embeddedTestJson

to test the static content:
http://localhost:8080/static/test.html

  