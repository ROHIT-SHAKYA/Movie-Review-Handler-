package backend.assignment.exception;

public class MovieNotFoundException extends RuntimeException{
	
	private static String message="Movie Not Found Execption";

	public MovieNotFoundException() {
	   super("Movie Not Found Execption");
	}

	
	MovieNotFoundException(String message)
	{
		super(message);
	}
}
