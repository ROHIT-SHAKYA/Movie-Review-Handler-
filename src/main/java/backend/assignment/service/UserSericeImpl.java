package backend.assignment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import backend.assignment.model.User;



@Service
public class UserSericeImpl implements UserService {

	@Override
	public void addUser(User user , List<User> usersList) throws Exception {
		// TODO Auto-generated method stub
		 if (user !=null) {
		
			   User person = new User();
		        person.setName(user.getName());
	
       
		        System.out.println("person Data" + person);
		        usersList.add(person);
		       

			    }
			    else {
			    	 
					
			    	throw new Exception("Please Provide user Deails");
			     
			    }
		
	
	}

	
}
