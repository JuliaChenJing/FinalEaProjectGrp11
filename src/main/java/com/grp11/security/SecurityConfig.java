package com.grp11.security;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	DataSource dataSource;
	
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
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/signUp").permitAll()
		.antMatchers("/consumer/signUp").permitAll()
		.antMatchers("/consumer/welcome").permitAll()
		.antMatchers("/login").permitAll()
		.antMatchers("/loginchecker").authenticated()
		.antMatchers(HttpMethod.GET, "/products/**").authenticated()
		.antMatchers(HttpMethod.GET, "/suppliers/**").authenticated()
		.antMatchers("/payments/**").authenticated()
		.antMatchers("/orders/**").authenticated()
		.antMatchers("/**").hasRole("ADMIN")
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.successForwardUrl("/consumer/welcome")
		.permitAll()
		.and()
		.logout().logoutSuccessUrl("/login").permitAll();
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
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery(
				"select user_domain.username,user_domain.password,1 from user_domain where user_domain.username=?")
		.authoritiesByUsernameQuery(
				"select user_domain.username,user_domain.role from user_domain where user_domain.username=?");
    }
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	  web.ignoring().antMatchers("/js/**");
	  web.ignoring().antMatchers("/css/**");
	}
    	

}
