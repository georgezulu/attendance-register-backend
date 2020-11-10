https://github.com/georgezulu/attendance-register-backend
Backend - (Spring Boot 2.* , H2 DB, Maven 3.2.*, Java 8)

Pull the Project into your Workstation
(On the command line) Change directory to the project's root folder
To compile the Application run the command >mvn clean install
To start the application run the command > mvn spring-boot:run (Tomcat server will be started on port 8080 localhost)
A bootstrap file named MyRunner.java will create all the necessary Tables in the H2 database and also insert
a few records for testing. 
Please note that the H2 DB works as an in-memory database, it is hosted within the same VM as the Spring boot server. The data stored 
will be wiped out once the server is shuts down. 

