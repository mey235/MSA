package com.example.orders;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class Course {
	@Id
    String courseid;
    String coursename;
    String authorname;
    Course()
    {
    	
    }
	public String getCourseid() {
		return courseid;
	}
	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public String getAuthorname() {
		return authorname;
	}
	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}
	Course(String courseid,String coursename,String authorname)
	{
		this.courseid=courseid;
		this.coursename=coursename;
		this.authorname=authorname;
		
	}
    
}
