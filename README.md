Weather
=======

This application (still in development) uses the REST APIs of https://openweathermap.org and https://teleport.org/

How to build
=======

You have to install the JDK (used for the development: jdk1.8.0_161) and GRADLE (used for the development: Gradle 4.5.1).

How to run
=======

To run it use the JAR file (that you will create with a Gradle build) into "build/libs" or use the commands "gradle clean build" and "gradle bootrun"; you also have to run "grunt sass" inside "src/main/resources/static"; after that you must go to "http://127.0.0.1:8080".
