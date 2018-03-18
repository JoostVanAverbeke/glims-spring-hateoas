# glims-spring-hateoas Project Overview

## Technical Requirements
Uses java projectlombok [https://projectlombok.org/](https://projectlombok.org/) for boilerplate code

### Installation instruction in the Eclipse IDE
See youtube movie [https://www.youtube.com/watch?v=5K6NNX-GGDI](https://www.youtube.com/watch?v=5K6NNX-GGDI)

## Inspired By
### HAL - Hypertext Application Language
  * [http://stateless.co/hal_specification.html](http://stateless.co/hal_specification.html)

### Implementing HAL hypermedia REST API using Spring HATEOAS
  * [https://opencredo.com/hal-hypermedia-api-spring-hateoas/](https://opencredo.com/hal-hypermedia-api-spring-hateoas/)

### Setting Up Swagger 2 with a Spring REST API
  * [http://www.baeldung.com/swagger-2-documentation-for-spring-rest-api](http://www.baeldung.com/swagger-2-documentation-for-spring-rest-api)
  * [https://springframework.guru/spring-boot-restful-api-documentation-with-swagger-2/](https://springframework.guru/spring-boot-restful-api-documentation-with-swagger-2/)

#### Experiment with the swagger 2 interface
Start the Spring REST application (eu.ten.fingers.glims.Application class main method)
and goto [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)


  
## Testing the Spring REST API
### Bootstrap your tests
  * [https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-testing.html](https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-testing.html)
  
### Use the MockMvcResultMatchers 
  * [https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/test/web/servlet/result/MockMvcResultMatchers.html](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/test/web/servlet/result/MockMvcResultMatchers.html) 
  * [https://github.com/json-path/JsonPath](https://github.com/json-path/JsonPath) 
  
## Spring Security
### Authentication
#### HTTP Basic authentication
This is the simplest form of authentication in the HTTP speci cation. It relies on a username and password combination being passed as an Authorization header to any HTTP request that mandates authentication.
When a client issues a request to an endpoint that requires authentication, the server will respond with a HTTP 401 Not Authorized response. The response will include the following header:

`WWW-Authenticate: Basic realm="myRealm"`

This header instructs the client that the user must be authenticated using the Basic scheme. Modern browsers will automatically prompt users for their credentials upon receiving such a response, and re-issue the request with the Authorization header. This header should contain the scheme followed by the username and password combination (in the format, username:password) encoded in Base64. For example, let's consider a request that contains the following header:

`Authorization: Basic cmVzdDpyb2Nrcw==`

Once decoded, the server will need to check for a user with the username, **spring**,
and password, **rocks**.

##### Using Basic authentication with Spring

Add the following dependencies to your **pom.xml** file:


	<dependency>
	     <groupId>org.springframework.security</groupId>
	     <artifactId>spring-security-config</artifactId>
	     <version>4.0.1.RELEASE</version>
	</dependency>
	<dependency>
	     <groupId>org.springframework.security</groupId>
	     <artifactId>spring-security-web</artifactId>
	     <version>4.0.1.RELEASE</version>
	</dependency>


 