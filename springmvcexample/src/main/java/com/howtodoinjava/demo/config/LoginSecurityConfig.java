//package com.howtodoinjava.demo.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class LoginSecurityConfig extends WebSecurityConfigurerAdapter{
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//			.withUser("viet")
//			.password("password")
//			.authorities("ROLE_USER");
//	}
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//			.antMatchers("/home")
//			.hasAnyRole("ROLE_USER")
//			.and()
//			.formLogin()
//			.loginPage("/login")
//			.permitAll()
//			.defaultSuccessUrl("/home")
//			.failureUrl("/login?error")
//			.usernameParameter("username")
//			.passwordParameter("password")
//			.and()
//			.logout()
//			.logoutSuccessUrl("/login?logout");
//	}
//}
