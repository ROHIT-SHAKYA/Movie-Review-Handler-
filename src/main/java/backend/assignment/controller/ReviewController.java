package backend.assignment.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import backend.assignment.exception.DuplicateReviewException;
import backend.assignment.exception.MovieNotReleasedException;
import backend.assignment.model.Movie;
import backend.assignment.model.Review;
import backend.assignment.model.User;
import backend.assignment.service.MovieService;
import backend.assignment.service.ReviewService;

@RestController
@RequestMapping("/api")
public class ReviewController {

	
	@Autowired
	ReviewService reviewService;
	
	@Autowired
	MovieService movieService;

	 List<Review> reviewsList=new ArrayList<Review>();
	 
	@PostMapping("/add/reviews")
	public void addReviews(@RequestBody Review review) throws Exception
	{
		
		//Duplicate Movie Review Case
		String userName=review.getMovieName();
		String movieName=review.getMovieName();
		
		for ( Review reviews : reviewsList) {
			
			if(reviews.getMovieName()==movieName && reviews.getUserName()==userName)
			{
				throw new DuplicateReviewException();
			}
				}
		
		//Movie Not Released Case
		
		Integer releaseYearOfMovie=movieService.findReleaseYearOfMovie(movieName);
		
		Date d=new Date();
		int currentYear=d.getYear();
		if(releaseYearOfMovie> currentYear)
		{
			throw new MovieNotReleasedException();
		}
		
		
		
		
		reviewService.addReview(review, reviewsList);
		 
	}
	

	@RequestMapping(value = "/average_review_score_of_movie/{movieName}/", method = RequestMethod.GET)
	public Double getAverageOfMovieRating(@PathVariable(value="movieName") String movieName)
	{
		
		
		double averageReviewScore=0.0;
		 averageReviewScore=reviewService.getAverageReviewScore(movieName);
		
		return averageReviewScore;
	}
	
	
	@GetMapping("/average_review_score_of_movie_yearly/{releaseYear}")
	public Double getAverageReviewScoreByYearly(@PathVariable (value = "releaseYear") Integer releaseYear)
	{
		double averageReviewScoreByReleaseYear=0.0;
		List<String> storeAllMoviesInGivenReleaseYear=movieService.findAllMoviesInGivenReleaseYear(releaseYear);
		
		 averageReviewScoreByReleaseYear=reviewService.getAverageReviewScoreYearly(storeAllMoviesInGivenReleaseYear);
		
		return averageReviewScoreByReleaseYear;
	}
	
	
	
	
}
