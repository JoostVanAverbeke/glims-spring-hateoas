# glims-spring-hateoas Project Overview

## Technical Requirements
Uses java projectlombok [https://projectlombok.org/](https://projectlombok.org/) for boilerplate code

### Installation instruction in the Eclipse IDE
See youtube movie [https://www.youtube.com/watch?v=5K6NNX-GGDI](https://www.youtube.com/watch?v=5K6NNX-GGDI)

## Inspired By
### HAL - Hypertext Application Language
  * [http://stateless.co/hal_specification.html](http://stateless.co/hal_specification.html)
  * [https://tools.ietf.org/html/draft-kelly-json-hal-08](https://tools.ietf.org/html/draft-kelly-json-hal-08)

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

#### Tips and Tricks  
<b>Very good tip</b>: andDo(print()), is very useful!



	mockMvc.perform(post("/public/users/login")
			.param("username", "trump")
			.param("password", "donald")
			.contentType(MediaType.APPLICATION_JSON))
	    	.andDo(print());    	   
  
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

#### REST Security with JWT (Json Web Token) using Spring Security
  * [https://www.toptal.com/java/rest-security-with-jwt-spring-security-and-java](https://www.toptal.com/java/rest-security-with-jwt-spring-security-and-java)
  * [https://octoperf.com/blog/2018/03/08/securing-rest-api-spring-security/](https://octoperf.com/blog/2018/03/08/securing-rest-api-spring-security/)
  
##### Testing the Application
First, let’s login on the REST API:

    $ curl -XPOST -d 'username=john&password=smith' http://localhost:8080/public/users/login 
    $ b856850e-1ad4-456d-b5ca-1c2bfc355e5 

By sending an url-encoded form post request to the endpoint, it returns as expected a random UUID. Now, let’s use the UUID in a subsequent request to retrieve the current user:

    $ curl -H 'Authorization: Bearer b856850e-1ad4-456d-b5ca-1c2bfc355e5e' http://localhost:8080/users/current
    $ {"id":"b856850e-1ad4-456d-b5ca-1c2bfc355e5e","username":"john","enabled":true}
    
Nice! We’re logged into the system and we could retrieve the current user in Json format. By default, Spring Boot uses Jackson Json API to serialize beans into Json.

Let’s now logout from the system:

    $ curl -H 'Authorization: Bearer b856850e-1ad4-456d-b5ca-1c2bfc355e5e' http://localhost:8080/users/logout
    $ true
    
If we try to get the current user again with the same authentication token, we should receive an error:

    $ curl -H 'Authorization: Bearer b856850e-1ad4-456d-b5ca-1c2bfc355e5e' http://localhost:8080/users/current 
    $ {"timestamp":1516184750678,"status":401,"error":"Unauthorized","message":"Authentication Failed: Bad credentials","path":"/users/current"}
    
##### Unit Testing the GET /orders REST Service

See [http://www.springboottutorial.com/unit-testing-for-spring-boot-rest-services](http://www.springboottutorial.com/unit-testing-for-spring-boot-rest-services)

### Test your REST services
Use app postman
For more info see [https://www.getpostman.com/](https://www.getpostman.com/)

#### POSTMAN User manual
See [https://support.brightcove.com/use-postman-api-requests](https://support.brightcove.com/use-postman-api-requests)                 