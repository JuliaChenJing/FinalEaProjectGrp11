package com.grp11.security;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	/*@Autowired
	DataSource dataSource;*/
	
	protected void configure(HttpSecurity http) throws Exception {
		/*http 
			.authorizeRequests()
			.antMatchers("/supplier/addsupplier").hasAuthority("USER")
			.antMatchers("/consumer/signUp").hasAuthority("ADMIN")
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage("/login")
			.successForwardUrl("/consumer/welcome")
			.permitAll();
*/
		
		http 
		.authorizeRequests()
		.antMatchers("/**").hasRole("ADMIN")
		.antMatchers("/consumer/signUp").hasRole("USER")
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.successForwardUrl("/consumer/welcome")
		.permitAll();
	}
	
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
             .inMemoryAuthentication()
                  .withUser("user")
                       .password("user")
                       .roles("USER")
                  .and()
                  .withUser("admin")
                  	.password("admin")
                  	.roles("ADMIN");
		/*auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery(
				"select user_domain.username,user_domain.password,1 from finalproject.user_domain where user_domain.username=?")
		.authoritiesByUsernameQuery(
				"select user_domain.username,user_domain.role from finalproject.user_domain where user_domain.username=?");*/
		/*auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery(
				"select user.name,user.password,1 from finalproject.user where user.name=?")
		.authoritiesByUsernameQuery(
				"select user.name,user.role from finalproject.user where user.name=? ");*/
    }
    	

}
