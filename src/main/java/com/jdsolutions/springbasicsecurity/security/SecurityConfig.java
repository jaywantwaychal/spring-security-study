package com.jdsolutions.springbasicsecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	//Authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication()
			.withUser("user")
			.password("user")
			.roles("USER")
			.and()
			.withUser("admin")
			.password("admin")
			.roles("ADMIN");
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	//authorization
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests()
			.antMatchers("/user/admin").hasRole("ADMIN")
			.antMatchers("/user/customer").hasRole("USER")
			.antMatchers("/").permitAll()
			.and()
			.formLogin();
	}
}
