# Spring Testing

https://reflectoring.io/spring-boot-web-controller-test/
https://reflectoring.io/spring-boot-exception-handling/



## Notes

(If you are using JUnit 5), You do NOT need to add

@RunWith(SpringRunner.class) on top of

@WebMvcTest(HelloWorldController.class)



JUnit 4 Code
@RunWith(SpringRunner.class)

@WebMvcTest(HelloWorldController.class)


JUnit 5 Code
@WebMvcTest(HelloWorldController.class)



ith the latest versions of Spring Boot (2.3+), the H2 database name is randomly generated each time you restart the server.

You can find the database name and URL from the console log.



RECOMMENDED: 

Make the database URL a constant by configuring this in application.properties.

spring.datasource.url=jdbc:h2:mem:testdb
spring.data.jpa.repositories.bootstrap-mode=default


DEBUGGING GUIDE (If you have problems)

JPA Hibernate Debugging Guide: https://github.com/in28minutes/in28minutes-initiatives/blob/master/The-in28Minutes-TroubleshootingGuide-And-FAQ/jpa-and-hibernate.md

Why do we need to configure bootstrap-mode? Details here - https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-2.3-Release-Notes#bootstrapmode-for-jpa-repositories


## References

https://github.com/in28minutes/MockitoTutorialForBeginners/tree/master/src/test/java/com/in28minutes/powermock

Intellij
https://www.jetbrains.com/help/idea/configuring-testing-libraries.html
https://blog.jetbrains.com/idea/2016/08/using-junit-5-in-intellij-idea/
Spring & Spring Boot Framework - https://www.youtube.com/watch?v=PSP1-2cN7vM&t=893s
Introduction to JPA and Hibernate using Spring Boot Data Jpa - http://www.springboottutorial.com/introduction-to-jpa-with-spring-boot-data-jpa
Functional Programming - https://youtu.be/aFCNPHfvqEU
JUnit - https://junit.org/junit5/docs/current/user-guide/
AssertJ - https://joel-costigliola.github.io/assertj/
Mockito - https://github.com/mockito/mockito/wiki/FAQ
JsonPath - https://github.com/json-path/JsonPath
Setting up JUnit 5 with Mockito and Spring Boot 2.0 - https://medium.com/@dSebastien/using-junit-5-with-spring-boot-2-kotlin-and-mockito-d5aea5b0c668
Good Unit Testing
https://github.com/mockito/mockito/wiki/How-to-write-good-tests
FIRST. https://pragprog.com/magazines/2012-01/unit-tests-are-first
Patterns - http://xunitpatterns.com
Mocking Static, Private Methods and Constructors
https://github.com/in28minutes/MockitoTutorialForBeginners/blob/master/Step15.md
https://github.com/in28minutes/MockitoTutorialForBeginners/tree/master/src/test/java/com/in28minutes/powermock