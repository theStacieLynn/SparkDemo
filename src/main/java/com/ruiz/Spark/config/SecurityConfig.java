package com.ruiz.Spark.config;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private DataSource datasource;
	
	@Bean
	static BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	/**
	 * create a method that authenticates a user by pulling username and password
	 * by pulling from the database
	 * 
	 */

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
				.authorizeHttpRequests()
				.requestMatchers("/**","/css/**").permitAll()
				
				.and()
				.formLogin(form -> form.loginPage("/login")
						.loginProcessingUrl("/login")
						.defaultSuccessUrl("/home")
						.permitAll())
				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.permitAll()
				
				.and()
				.exceptionHandling()
				.accessDeniedPage("/accessdenied");
		return http.build();
	}

//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws
//	Exception {
//	auth
//	.userDetailsService(userDetailsService)
//	.passwordEncoder(passwordEncoder());
//	}
	
//	@Bean
//	protected InMemoryUserDetailsManager configAuthentications() {
//		List<UserDetails> users = new ArrayList<>();
//		List<GrantedAuthority> userAuthority = new ArrayList<>();
//		userAuthority.add(new SimpleGrantedAuthority("USER"));
//		UserDetails user = new User("hp@hogwarts.edu","{noop}hp2000",userAuthority);
//		users.add(user);
//		return new InMemoryUserDetailsManager(users);
//	}
//	
//	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//		http.authorizeHttpRequests()
//			.requestMatchers("/home").permitAll()
//			.requestMatchers("/collections/**").permitAll()
//			.requestMatchers("/**").permitAll()
//			.requestMatchers("/orders/**").hasAnyAuthority("USER")
//			
//			.anyRequest().authenticated()
//			
//			.and()
//			.formLogin()
//			.defaultSuccessUrl("/orders",true)
//			
//			.and()
//			.logout()
//			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//			
//			//exception handling
//			.and()
//			.exceptionHandling()
//			.accessDeniedPage("/accessedDenied");
//		
//		
//			//finally we need to build
//			return http.build();
//	}
	
}
