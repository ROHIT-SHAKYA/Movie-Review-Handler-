package backend.assignment.exception;

public class DuplicateReviewException extends RuntimeException{
	
	private static String message="Review Already Added !!";

	public DuplicateReviewException() {
	   super("Review Already Added !!");
	}

	
	DuplicateReviewException(String message)
	{
		super(message);
	}
}
