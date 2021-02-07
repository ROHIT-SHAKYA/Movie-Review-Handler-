package backend.assignment.exception;

public class MovieNotReleasedException extends RuntimeException{
	
	private static String message="Movie Not Released Yet !!";

	public MovieNotReleasedException() {
	   super("Movie Not Released Yet !!");
	}

	
	MovieNotReleasedException(String message)
	{
		super(message);
	}
}
