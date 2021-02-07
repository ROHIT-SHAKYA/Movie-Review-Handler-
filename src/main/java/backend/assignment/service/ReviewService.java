package backend.assignment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import backend.assignment.model.Review;



@Service
public interface ReviewService {
	
	public void addReview(Review review , List<Review> reviewsList) throws Exception;
	public List<String> getAllcriticUsers();
	public List<String> getAllTopNmovies(int numberOfMovies);
    public double getAverageReviewScore(String movieName);
	public double getAverageReviewScoreYearly(List<String> storeAllMoviesInGivenReleaseYear);
   
	
	

}
