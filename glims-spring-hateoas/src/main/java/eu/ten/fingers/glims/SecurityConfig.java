package eu.ten.fingers.glims;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * This is a very simple configuration that is not production-ready but is simple enough 
 * to illustrate the configuring of Spring Security. 
 * We define one user with the username, <b>spring</b>, and password, <b>rocks</b>. 
 * We also instruct Spring to authenticate all requests using the HTTP Basic authentication scheme.
 * 
 * @author joost
 *
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
			auth.inMemoryAuthentication() .withUser("spring").password("rocks").roles("USER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated().and().httpBasic();		
	}
}
