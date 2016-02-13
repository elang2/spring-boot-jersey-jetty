# Sample Spring Boot applicaion using Jetty, Jersey, Hibernate ,JPA


###Pre-requisite:

1. Java SDK 1.8
2. Maven 3.0+
3. MySQL 


###Instructions :

* Git pull the repo.

* Run mvn eclipse:eclipse on the root folder (spring-boot-jersey-jetty).

* Import into STS(preferred) or Eclipse.

* If using STS then you can directly run the SpringBootSampleApplication class like a stand alone Java application.

* If not using STS then you can run the 'start.sh' script on the root folder to start the application.

*  Alternatively you can also use mvn spring-boot:run to start the application. This script take the configurations defined in ./jetty/application.properties file.

* The ./jetty/application.properties file can be considered a overrides configuration file. More like an external configuration file. Spring boot can be made to use this external configuration file instead of the application.properties file in the WebArchive by passing the following in the VM arguments when starting the application or the Jetty container.

>  -Dspring.config.location=<path to the file>application.properties

* Example Endpoints :
 
   HTTP GET : [http://localhost:9001/spring-boot-app/user/123](https://localhost:9001/spring-boot-app/user)

   HTTP Get : [http://localhost:9001/spring-boot-app/user?minAge=10&maxAge=90](https://localhost:9001/spring-boot-app/user)
   
   HTTP Post: [https://localhost:9001/spring-boot-app/user](https://localhost:9001/spring-boot-app/user)   
   
        [Make sure to have the UserDTO object or fields in the request payload for POST]


