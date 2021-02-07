package backend.assignment.model;

import lombok.Getter;
import lombok.Setter;


public class Movie {

	

	private String movieName;
	private String movieDescription;
	private String movieType;
	private Integer releaseDate;
	
	public Movie()
	{
		
	}

	public Movie(String movieName, String movieDescription, String movieType, Integer releaseDate) {
		super();
	
		this.movieName = movieName;
		this.movieDescription = movieDescription;
		this.movieType = movieType;
		this.releaseDate = releaseDate;
	}


	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public Integer getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Integer releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getMovieType() {
		return movieType;
	}
	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}
	public String getMovieDescription() {
		return movieDescription;
	}
	public void setMovieDescription(String movieDescription) {
		this.movieDescription = movieDescription;
	}
	
}
