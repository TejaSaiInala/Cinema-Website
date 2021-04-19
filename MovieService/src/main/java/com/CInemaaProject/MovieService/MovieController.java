package com.CInemaaProject.MovieService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.CInemaaProject.MovieService.Model.Movie;
import com.CInemaaProject.MovieService.Model.Screen;
//import com.CInemaaProject.MovieService.Model.TheatreServiceProxy;
import com.CInemaaProject.MovieService.Model.Theatremovie;
import com.CInemaaProject.MovieService.repository.MovieRepository;


@Controller
public class MovieController {

	@Autowired
	private MovieRepository movieRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	/*
	 @Autowired private theatreServiceProxy theatreProxy;
	 */
	
	@GetMapping("/movies")
	@ResponseBody
	public List<Movie> retrieveMovies()
	{
		return movieRepo.findAll();
	}
	
	@GetMapping("/movie/{id}")
	@ResponseBody
	public Optional<Movie> retrieveMovie(@PathVariable long id)
	{
		return movieRepo.findById(id);
	}
	
	@GetMapping("/movie/{id}/theatres")
	@ResponseBody
	public List<Theatremovie> retrieveMoviesforTheatre(@PathVariable long id)
	{
		
		HashMap<String,Long> uriVariables = new HashMap<>();
		
		uriVariables.put("id", id);	
		/*
		 * ResponseEntity<Theatremovie[]> responseEntity = new RestTemplate()
		 * .getForEntity("http://localhost:8000/theatre/movies/{id}",
		 * Theatremovie[].class, uriVariables);
		 */
		
		ResponseEntity<Theatremovie[]> responseEntity = restTemplate
				  .getForEntity("http://THEATRE-SERVICE/theatre/movies/{id}",
				  Theatremovie[].class, uriVariables);
		
		Theatremovie[] body = responseEntity.getBody();
		
		return Arrays.asList(body);
	}
	
	
	/*
	 * @GetMapping("/{id}/movies/feign")
	 * 
	 * @ResponseBody public List<Theatremovie> getMovieforTheatreFeign(@PathVariable
	 * long id) { return theatreProxy.getMovieforTheatre(id); }
	 */
	
	@GetMapping("/movie/{id}/theatre/{tid}/screens")
	@ResponseBody
	public List<Screen> retrieveScreensForMovie(@PathVariable long id, @PathVariable long tid)
	{
		HashMap<String,Long> uriVariables = new HashMap<>();
		
		//uriVariables.put("id", id);
		uriVariables.put("tid", tid);
		ResponseEntity<Screen[]> responseEntity = restTemplate
				.getForEntity("http://THEATRE-SERVICE/theatre/{tid}/screens", 
						 Screen[].class,uriVariables);
		
		Screen[] body = responseEntity.getBody();
		
		List<Theatremovie> lst = retrieveMoviesforTheatre(id);
		List<Screen> lstScreen = Arrays.asList(body);
		
		List<Screen> result = new ArrayList<>();
		
		for(int i=0;i<lst.size();i++)
		{
			for(int j=0;j<lstScreen.size();j++)
			{
				if(lst.get(i).getScreenId() == lstScreen.get(j).getScreenId())
				{
					result.add(lstScreen.get(j));
					continue;
				}
			}
		}
		return result;
	}
	
	@PostMapping("/movie/register")
	public Movie createMovie(@RequestBody Movie movie)
	{
		return movieRepo.save(movie);
	}

	
}
