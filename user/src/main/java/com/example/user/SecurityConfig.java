package com.example.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.memory.*;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig  {

	
	 @Bean
	    public UserDetailsService userDetailsService() {
		 
	       return new CustomUserDetailsService();
	    }
	

	 @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

	    @Bean
	    public AuthenticationProvider authenticationProvider() {
	        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
	        authenticationProvider.setUserDetailsService(userDetailsService());
	        authenticationProvider.setPasswordEncoder(passwordEncoder());
	        return authenticationProvider;
	    }
	 @SuppressWarnings("removal")
	@Bean
	    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		 http
		 .csrf().disable()
		 .cors()
		 .and()
         .authorizeHttpRequests((authz) -> authz
             .requestMatchers("/regster").permitAll()
             .requestMatchers("users/create").permitAll()
             .requestMatchers("users/**").permitAll()
             .anyRequest().authenticated()
         ).formLogin((login) ->login
           .defaultSuccessUrl("http://localhost:3000/target-route"))
          .userDetailsService(userDetailsService());
        
          
         return http.build();
         

	        
	    }
}


