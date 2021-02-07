package backend.assignment.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.assignment.model.Movie;
import backend.assignment.service.MovieService;
import backend.assignment.service.ReviewService;
import backend.assignment.service.UserService;

@RestController
@RequestMapping("/api")
public class MovieController {

	
	@Autowired
	MovieService movieService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	ReviewService reviewService;

	 List<Movie> moviesList=new ArrayList<Movie>();
	 
	@PostMapping("/add/movies")
	public void addMovies(@RequestBody Movie movie) throws Exception
	{
		movieService.addMovie(movie, moviesList);
		 
	}
	
	
	
	@GetMapping("/find/topNmovies/critics/{numberOfMovies}")
	public List<String> topNcriticsMovies( @PathVariable (value = "numberOfMovies") int numberOfMovies)
	{
		//This list have All critics Users
		List<String>criticsUsers = reviewService.getAllcriticUsers();
		
		
		 // Top N Movies review by critics Users 
		List<String>topNmovies = reviewService.getAllTopNmovies(numberOfMovies);
		
		return topNmovies;	
	}
	

	
	
	
}
