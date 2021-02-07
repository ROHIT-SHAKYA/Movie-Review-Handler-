package backend.assignment.model;

import java.util.Date;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ser.std.SerializableSerializer;

import lombok.Getter;
import lombok.Setter;



public class User  {
	
	
	private String Name;
	


	public User(String name) {
		super();
		Name = name;
	}



	public String getName() {
		return Name;
	}



	public void setName(String name) {
		Name = name;
	}



	public User() {
		// TODO Auto-generated constructor stub
	}
	
	

}
