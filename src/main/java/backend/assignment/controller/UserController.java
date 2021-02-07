package backend.assignment.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.assignment.exception.UserNotFoundExecption;
import backend.assignment.model.User;
import backend.assignment.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserService userService;
	 List<User> usersList=new ArrayList<User>();
	 
	@PostMapping("/add/users")
	public void AddUser(@RequestBody User user) throws Exception
	{
		userService.addUser(user, usersList);
		  System.out.println("User data");
			for ( User user1 : usersList) {
				System.out.println(user1);
			}
	}
	
	
	@GetMapping("/show/users")
	public void showUsers() 
	{
		
		if(usersList.size()==0)
			throw new UserNotFoundExecption();
		System.out.println("Users data");
		for ( User user : usersList) {
     System.out.println("Name : " +user.getName() +"\n"+
                     "\n"+"\n"); 
		}
	// return usersList;
	}
	
	
}
