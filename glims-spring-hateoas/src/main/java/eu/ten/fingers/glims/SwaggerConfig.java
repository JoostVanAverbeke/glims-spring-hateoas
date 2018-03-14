package eu.ten.fingers.glims;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
    	ResponseMessage response500Message = new ResponseMessageBuilder()
		.code(500)
		.message("500 message")
		.responseModel(new ModelRef("Error")).build();
    	
    	ResponseMessage errorResponseMessage = new ResponseMessageBuilder()
    	.code(403)
    	.message("Forbidden!!!!!")
    	.build();
        List<ResponseMessage> responseMessages = new ArrayList<ResponseMessage>();
        responseMessages.add(response500Message);
        responseMessages.add(errorResponseMessage);
        		
    	return new Docket(DocumentationType.SWAGGER_2)
        	.select()
        	.apis(RequestHandlerSelectors.basePackage("eu.ten.fingers.glims.controllers"))
//        	.paths(PathSelectors.ant("/orders/*"))
        	.paths(PathSelectors.any())
        	.build()
        	.apiInfo(apiInfo())
        	.useDefaultResponseMessages(false)
            .globalResponseMessage(RequestMethod.GET, responseMessages);
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo("My REST API", "Some custom description of API.", 
        		"API TOS", "Terms of service", 
        		new Contact("Joost Van Averbeke", "http://www.10fingers.eu", "joost.van.averbeke@telenet.be"), 
        		"License of API", "API license URL", Collections.emptyList());
        return apiInfo;
    }

}