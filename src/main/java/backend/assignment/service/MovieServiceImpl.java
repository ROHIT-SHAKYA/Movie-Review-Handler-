package backend.assignment.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;



import backend.assignment.model.Movie;


@Service
public class MovieServiceImpl implements MovieService {
	
	HashMap<String, Integer> storeMoviesByReleaseYearMap = new HashMap<String, Integer>(); 
	List<String> storeMoviesByReleaseYearList = new ArrayList<>();
	//HashMap<String, Integer> MovieFrequencyMapYearWise = new HashMap<String, Integer>(); 
	
	
	
	
	@Override
	public void addMovie(Movie movie , List<Movie> moviesList) throws Exception {
		// TODO Auto-generated method stub
		 if (movie !=null) {

			   Movie movie1 = new Movie();
			   movie1.setMovieName(movie.getMovieName());
			   movie1.setMovieDescription(movie.getMovieDescription());
			   movie1.setMovieType(movie.getMovieType());
			   
			   //calculate the movie year from Description
			   Integer movieReleaseYear=findReleaseDate(movie.getMovieDescription());
			   movie1.setReleaseDate(movieReleaseYear);
		    
			   
		       storeMoviesByReleaseYear(movie.getMovieName(),movieReleaseYear);
       
		        System.out.println("Movie Data" + movie);
		        moviesList.add(movie1);
		        
		       

			    }
			    else {
			    	
			    	throw new Exception("Movie Cannot Be Added.");
			     
			    }
		
	
	}
	  
	
  
        

	private Integer findReleaseDate(String movieDescription) {
		// TODO Auto-generated method stub
		
		movieDescription = movieDescription.replaceAll("[^\\d]", " "); 
        
        // Remove extra spaces from the beginning 
        // and the ending of the string 
		movieDescription = movieDescription.trim(); 
  
        // Replace all the consecutive white 
        // spaces with a single space 
		movieDescription = movieDescription.replaceAll(" +", " "); 
  
        if (movieDescription.equals("")) 
            return -1; 
  
        return Integer.parseInt(movieDescription); 
		
	}
	
	

	public List<String> storeAllMoviesInGivenReleaseYear(Integer releaseYear) {
		// TODO Auto-generated method stub
		List<String> moviesName=findAllMoviesInGivenReleaseYear(releaseYear);
		
		
		return moviesName;
	}
	
    public List<String> findAllMoviesInGivenReleaseYear(Integer releaseYear) {
		// TODO Auto-generated method stub
    	
    	 Iterator hmIterator = storeMoviesByReleaseYearMap.entrySet().iterator(); 
    	 
         System.out.println("HashMap after adding bonus marks:"); 
   
         while (hmIterator.hasNext()) { 
             Map.Entry mapElement = (Map.Entry)hmIterator.next(); 
             int year = ((int)mapElement.getValue()); 
             if(year==releaseYear)
            	 storeMoviesByReleaseYearList.add((String) mapElement.getKey());
             
             
         } 
    	
		return storeMoviesByReleaseYearList;
	}





	void storeMoviesByReleaseYear(String movieName,int releaseYear) 
    { 
       
    	
    	
            if (storeMoviesByReleaseYearMap.containsKey(movieName)) { 
            //do nothing - no need of this my movieName is a key
            	
            } 
            else { 
  
             //map movie with a Release year
            	storeMoviesByReleaseYearMap.put(movieName, releaseYear); 
            
            	
            } 
    }





	@Override
	public Integer findReleaseYearOfMovie(String movieName) {
		// TODO Auto-generated method stub
		
		return storeMoviesByReleaseYearMap.get(movieName);
	}
	
}
