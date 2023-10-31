package com.example.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class Projectcontroller {
	@Autowired
	private	ORD de;
    @Autowired	
	 RestTemplate deb;
@RequestMapping("/courses")
public Orders  getcourse()
{
	 ResponseEntity<USER> responseEntity = deb
             .getForEntity("http://localhost:8085/users/653ec1e7e24dd9483e1acb3a",
             USER.class);
	 ResponseEntity<Course> responseEntitys = deb
             .getForEntity("http://localhost:8080/courses/amer",
             Course.class);
	 USER one = responseEntity.getBody();
	 Course two = responseEntitys.getBody();
	 Orders men = new Orders("234",one,two);
	 de.save(men);
	 return men;
}
}
