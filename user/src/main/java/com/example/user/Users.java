package com.example.user;

import java.util.HashSet;

import java.util.Set;

import org.springframework.data.mongodb.core.mapping.Document;



@Document
public class Users {
    String username;
    String name;
    String password;
    String address;
    String pincode;
    long phonenumber;
    String email;

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public long getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}
	public Users(String username, String name, String password, String address, String pincode, long phonenumber,String email) {
		
		this.username = username;
		this.name = name;
		this.password = password;
		this.address = address;
		this.pincode = pincode;
		this.phonenumber = phonenumber;
		this.email=email;
	}
}
