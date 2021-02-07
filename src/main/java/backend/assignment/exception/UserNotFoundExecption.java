package backend.assignment.exception;

public class UserNotFoundExecption extends RuntimeException{
	
	private static String message="User Not Found !!";

	public UserNotFoundExecption() {
	   super("User Not Found !!");
	}

	
	UserNotFoundExecption(String message)
	{
		super(message);
	}
}
