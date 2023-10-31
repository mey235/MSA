package com.example.user;


import java.util.Arrays;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
@RestController
@RequestMapping("/users")
public class UserController {
     @Autowired
     REPO rep;
     @Autowired
     PasswordEncoder passwordEncoder;
	@RequestMapping("/user")
	public Users getuser()
	{
		long med=1231231123;
		String nel = passwordEncoder.encode("lemon23");
		Users fe = new Users("amey50","ameynimbalkar",nel,"1003aphrodite raheja","400088",med,"ameynimbalkar83@gmail.com");
		
		return fe;	
		
	}
	@GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable String id) {
        Users user = rep.findById(id).orElse(null);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
	@RequestMapping("/create")
    public ResponseEntity<Users> createUser(@RequestBody Users user) {
		Users newUser = rep.save(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
	@RequestMapping("/userd")
	public Users getloggedinuser()
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	     String username = authentication.getName();
		Users one = rep.findByUsername(username);
		System.out.println(username);
		return one;
		
	}
}

