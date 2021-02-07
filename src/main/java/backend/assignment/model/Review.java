package backend.assignment.model;

public class Review {
	

	private String userName;
	private String  movieName;
	private Integer movieRating;
	
	
	public Review() {}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getMovieName() {
		return movieName;
	}


	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}


	public Integer getMovieRating() {
		return movieRating;
	}


	public void setMovieRating(Integer movieRating) {
		this.movieRating = movieRating;
	}


	public Review(String userName, String movieName, Integer movieRating) {
		super();
		this.userName = userName;
		this.movieName = movieName;
		this.movieRating = movieRating;
	}
	


}
