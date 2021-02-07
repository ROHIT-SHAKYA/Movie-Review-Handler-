package backend.assignment.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import org.springframework.stereotype.Service;

import backend.assignment.exception.ReviewDoesNotExistException;
import backend.assignment.model.Review;



@Service
public class ReviewServiceImpl implements ReviewService{
	
	public static final int CRITIC_USER_LIMIT = 3; 
	 HashMap<String, Integer> criticUserCountMap = new HashMap<String, Integer>(); 
	 List<String> allCriticUsers=new ArrayList<>();
	 List<String> AllMoviesNamesrReviewsGivenByUsers=new ArrayList<>();
	 HashMap<String, Integer> MovieTotalRatingMap = new HashMap<String, Integer>(); 
	 HashMap<String, Integer> MovieFrequencyMap = new HashMap<String, Integer>(); 
	 
	 
	 
	 

	@Override
	public void addReview(Review review, List<Review> reviewsList) throws Exception {
		// TODO Auto-generated method stub
		if (review !=null) {

			   Review review1 = new Review();
			   review1.setMovieName(review.getMovieName());
			   review1.setUserName(review.getUserName());
			   review1.setMovieRating(review.getMovieRating());
			
			   
			   
			   
			   // calculate critic User after each review
			   criticUserCount(review.getUserName(),review.getMovieName()); 
			   CountRatingofAllMovie(review.getMovieName(),review.getMovieRating());
		        System.out.println("Movie Data" + review1);
		        reviewsList.add(review1);
		       

			    }
			    else {
			    	
			    	throw new Exception("Review Cannot Be Added.");
			     
			    }
		
	}
	

	
	
	

    void criticUserCount(String userName,String movieName) 
    { 
       
    	
    	
            if (criticUserCountMap.containsKey(userName)) { 
  
             
            	criticUserCountMap.put(userName, criticUserCountMap.get(userName) + 1); 
            	
            	
            	
            	if(criticUserCountMap.get(userName)==CRITIC_USER_LIMIT)
            	{
            		if(!allCriticUsers.contains(userName))        // if this  statement is not true then only add // duplicated date issue
            		{
            			allCriticUsers.add(userName);
            			
            		}
            		
            		AllMoviesNamesrReviewsGivenByUsers.add(movieName);
            		//this list have all the movies which is review critic Users
            	}

            } 
            else { 
  
                // If char is not present in charCountMap, 
                // putting this char to charCountMap with 1 as it's value 
            	criticUserCountMap.put(userName, 1); 
            	
            
            	
            } 
    }
    
    
    void CountRatingofAllMovie(String movieName,int ratings) 
    { 
       
    	
    	
            if (MovieTotalRatingMap.containsKey(movieName)) { 
  
             
            	
            	MovieTotalRatingMap.put(movieName,MovieTotalRatingMap.get(movieName) + ratings);
            	MovieFrequencyMap.put(movieName,MovieFrequencyMap.get(movieName)+1);
            	
            	
            	

            } 
            else { 
  
                // If char is not present in charCountMap, 
                // putting this char to charCountMap with 1 as it's value 
            	MovieTotalRatingMap.put(movieName, ratings); 
            	MovieFrequencyMap.put(movieName,1);
            
            	
            } 
    }
    
    
	@Override
	public List<String> getAllcriticUsers() {
		// TODO Auto-generated method stub
		return allCriticUsers;
	}







	@Override
	public List<String> getAllTopNmovies(int numberOfMovies) {
		// TODO Auto-generated method stub
		
		List<String> topNmovies = topKFrequent((String[]) AllMoviesNamesrReviewsGivenByUsers.toArray(),numberOfMovies);
		
		return topNmovies;
	}
	
	
public List<String> topKFrequent(String[] words, int k) {
        
        List<String> result = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<words.length; i++)
        {
            if(map.containsKey(words[i]))
                map.put(words[i], map.get(words[i])+1);
            else
                map.put(words[i], 1);
        }
        
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                 (a,b) -> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue()
        );
        
        for(Map.Entry<String, Integer> entry: map.entrySet())
        {
            pq.offer(entry);
            if(pq.size()>k)
                pq.poll();
        }

        while(!pq.isEmpty())
            result.add(0, pq.poll().getKey());
        
        return result;
    }






@Override
public double getAverageReviewScore(String movieName) {
	// TODO Auto-generated method stub
	
	if ( !MovieTotalRatingMap.containsKey(movieName))
	{
		throw new ReviewDoesNotExistException();
	}
	
  int totalFreq=MovieFrequencyMap.get(movieName);	
  Double totalFrequency=Double.valueOf(totalFreq);
  
  int totalRating=MovieTotalRatingMap.get(movieName);
  Double totalRatingOfMovie=Double.valueOf(totalRating);
  
  if(totalRatingOfMovie <0 || totalFreq<0)
	  throw new ReviewDoesNotExistException();
  
  return totalRatingOfMovie/totalFreq;


}






@Override
public double getAverageReviewScoreYearly(List<String> storeAllMoviesInGivenReleaseYear) {
	// TODO Auto-generated method stub
	Integer totalRatingOfMovie=0;
	

	
	//total ratings of a movies which was release in given Year - - list will contain all movies which were release in this year

	for (String string : storeAllMoviesInGivenReleaseYear) {
		totalRatingOfMovie+=MovieTotalRatingMap.get(string);
	} 
	
	  Double totalRatingOfMovieYearly=Double.valueOf(totalRatingOfMovie);
	  
	  
	  Integer totalNumberOfReview=0;
	  for (String string : storeAllMoviesInGivenReleaseYear) {
		  totalNumberOfReview+=MovieFrequencyMap.get(string);
		} 
	  
	  
	  Double totalNumberOfReviews=Double.valueOf(totalNumberOfReview);
	  
	  if(totalRatingOfMovieYearly <0 || totalNumberOfReviews<0)
		  throw new ReviewDoesNotExistException();
	  
	  return totalRatingOfMovieYearly/totalNumberOfReviews;
	  
}

}
