package com.example.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


	@Service
	public class CustomUserDetailsService implements UserDetailsService {

	    @Autowired
	    private REPO userRepository;

	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        Users user = userRepository.findByUsername(username);

	        if (user == null) {
	            throw new UsernameNotFoundException("User not found");
	        }

	        return User.withUsername(user.getUsername())
	            .password(user.getPassword())
	            .roles("USER")
	            .build();
	    }
	}

