package com.te.ramayana.Securityconfig;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.te.ramayana.RamayanaApplication;
import com.te.ramayana.service.serviceimpl.HerosServiceImpl;




@Configuration
@EnableWebSecurity
@EnableWebMvc
public class Mysecurityconfig extends WebSecurityConfigurerAdapter{
	
	public static final String[] PUBLI_URLS= {
			"/api/v1/auth/**",
			"/v3/api-docs",
			"/v2/api/docs",
			"swagger-resources/**",
			"/swagger-ui/**",
			"/webjars/**"
	};
	
	
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.csrf().disable()
				.authorizeRequests()
				.antMatchers(HttpMethod.POST).hasRole("ADMIN")
				.antMatchers(HttpMethod.GET).hasRole("NORMAL")
				//.antMatchers("/v3/api-docs").permitAll()
				.antMatchers(PUBLI_URLS).permitAll()
				.anyRequest()
				.authenticated()
				.and()
				.httpBasic();
//				.formLogin();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("csmaker").password(this.encoder().encode("123")).roles("NORMAL");
		auth.inMemoryAuthentication().withUser("admin").password(this.encoder().encode("1234")).roles("ADMIN");
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder(10);
	}
	
	

}
