package backend.assignment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import backend.assignment.model.Movie;
import backend.assignment.model.User;

@Service
public interface MovieService {

	public void addMovie(Movie movie , List<Movie> moviesList) throws Exception;
	 public List<String> findAllMoviesInGivenReleaseYear(Integer releaseYear);
	public  Integer findReleaseYearOfMovie(String movieName);
}
