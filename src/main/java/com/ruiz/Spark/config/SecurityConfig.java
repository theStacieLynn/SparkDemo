package com.ruiz.Spark.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
	

	@Bean
	public static PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
				.authorizeHttpRequests()
				.requestMatchers("/**","/css/**").permitAll()
				
				.and()
				.formLogin(form -> form.loginPage("/login")
						.loginProcessingUrl("/login")
						.defaultSuccessUrl("/home/")
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
