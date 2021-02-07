package backend.assignment.exception;

public class ReviewDoesNotExistException extends RuntimeException{
	
	private static String message="Movie Review Does Not Exist !!";

	public ReviewDoesNotExistException() {
	   super("Movie Review Does Not Exist !!");
	}

	
	ReviewDoesNotExistException(String message)
	{
		super(message);
	}
}
