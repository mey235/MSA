package com.example.orders;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Orders {
	String orderid;
	USER user;
	Course course;
	public Orders()
	{
		
	}
	public Orders(String orderid, USER user, Course course) {
		this.orderid = orderid;
		this.user = user;
		this.course = course;
	}
	
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public USER getUser() {
		return user;
	}
	public void setUser(USER user) {
		this.user = user;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
	

}
