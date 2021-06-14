package com.CinemaaProject.theatreservice;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.CinemaaProject.theatreservice.model.Movie;
import com.CinemaaProject.theatreservice.model.Screen;
import com.CinemaaProject.theatreservice.model.ScreenMovie;
import com.CinemaaProject.theatreservice.model.Theatre;
import com.CinemaaProject.theatreservice.model.TheatreEnvironment;
import com.CinemaaProject.theatreservice.model.Theatremovie;
import com.CinemaaProject.theatreservice.model.usersHistory;
import com.CinemaaProject.theatreservice.repository.screenRepository;
import com.CinemaaProject.theatreservice.repository.theatreMovieRepository;
import com.CinemaaProject.theatreservice.repository.theatreRepository;

@RestController
public class TheatreController {

	@Autowired
	screenRepository repo;

	@Autowired
	theatreRepository Trepo;

	@Autowired
	private theatreMovieRepository tmRepo;

	@Autowired
	private RestTemplate restTemplate;

	/*
	 * @Autowired MovieRepository mRepo;
	 */

	@Autowired
	private Environment env;

	@RequestMapping("/theatres")
	public List<Theatre> retrieveTheatres(Model model) {
		return Trepo.findAll();
	}

	@GetMapping("/theatre/{id}")
	public Optional<Theatre> retrieveTheatreInforById(@PathVariable long id) {
		return Trepo.findById(id);
	}

	@PatchMapping("/theatre/update")
	public Theatre theatreUpdate(@RequestBody Theatre thea) {
		return Trepo.save(thea);
	}

	@CrossOrigin(origins = "http://localhost:3001")
	@PostMapping("/theatre/register")
	public Theatre registerTheatre(@RequestBody Theatre thea) {
		return Trepo.save(thea);
	}

	@GetMapping("screen/{id}")
	public Optional<Screen> retrieveScreenforTheatre(@PathVariable long id) {
		return repo.findById(id);
	}

	@GetMapping("screens")
	public List<Screen> retrieveAllScreens() {
		return repo.findAll();
	}

	@GetMapping("theatre/{id}/screens")
	public List<ScreenMovie> retrieveScreensByTheatreID(@PathVariable long id) {
		HashMap<String, Long> uriVariables = new HashMap<>();
		List<Screen> lst = repo.findByTheatreId(id);

		Screen sc = new Screen();
		theatreMovieController tm = new theatreMovieController();
		List<ScreenMovie> res = new ArrayList<ScreenMovie>();
		for (int i = 0; i < lst.size(); i++) {
			ScreenMovie s = new ScreenMovie();
			sc = lst.get(i);
			long sid = sc.getScreenId();
			List<Theatremovie> ltm = tmRepo.findByScreenId(sid);

			if(!ltm.isEmpty())
			{
				uriVariables.put("id", ltm.get(0).getMovieId());

				ResponseEntity<Movie> responseEntity = restTemplate.getForEntity("http://MOVIE-SERVICE/movie/{id}",
						Movie.class, uriVariables);

				Movie body = responseEntity.getBody();

				s.setCapacity(sc.getCapacity());
				s.setOccupiedCapacity(sc.getOccupiedCapacity());
				s.setScreenId(sc.getScreenId());
				s.setShowDate(sc.getShowDate());
				s.setShowTime(sc.getShowTime());
				if(body!=null)
				{
					s.setMovieName(body.getName());
				}
				s.setTheatreId(sc.getTheatreId());
				res.add(s);
			}
		
		}
		return res;
	}

	@PostMapping("theatre/{id}/addScreen")
	public Screen addScreen(@RequestBody Screen screen) {
		return repo.save(screen);
	}
	
	
	/*
	 * @PostMapping("/movie/register") public boolean addMovieTheatre(@RequestBody
	 * MovieScreen ms) { //com.CInemaaProject.MovieService.MovieController.class int
	 * mid = 0; com.CInemaaProject.MovieService.Model.Movie movie =
	 * mRepo.findByName(ms.getMovieName());
	 * 
	 * if(movie == null) { movie.setGenre(ms.getGenre());
	 * movie.setName(ms.getMovieName()); // Add the movie as it is new
	 * com.CInemaaProject.MovieService.Model.Movie movie1 = mRepo.save(movie); mid =
	 * (int) movie1.getId(); }
	 * 
	 * 
	 * if(mid == 0) { com.CInemaaProject.MovieService.Model.Movie movie = new
	 * com.CInemaaProject.MovieService.Model.Movie(); movie.setGenre(ms.getGenre());
	 * movie.setName(ms.getMovieName()); // Add the movie as it is new
	 * com.CInemaaProject.MovieService.Model.Movie movie1 = mc.createMovie(movie);
	 * mid = movie1.getId(); }
	 * 
	 * 
	 * Screen sc = new Screen(); sc.setCapacity(ms.getSeats());
	 * sc.setOccupiedCapacity(0); int d =
	 * Integer.parseInt(ms.getShowDate().substring(0,2)); int m =
	 * Integer.parseInt(ms.getShowDate().substring(3, 5)); int y =
	 * Integer.parseInt(ms.getShowDate().substring(7)); Date showDate = new Date(y,
	 * m, d); sc.setShowDate(showDate);
	 * 
	 * d = Integer.parseInt(ms.getShowTime().substring(0,2)); m =
	 * Integer.parseInt(ms.getShowTime().substring(3, 5)); y =
	 * Integer.parseInt(ms.getShowTime().substring(7)); Time showTime = new Time(d,
	 * m, y); sc.setShowTime(showTime);
	 * 
	 * Screen scRes = addScreen(sc);
	 * 
	 * Theatremovie tm = new Theatremovie(); tm.setMovieId(mid);
	 * tm.setTheatreId(ms.getTheatreId()); tm.setScreenId(scRes.getScreenId());
	 * theatreMovieController tmc = new theatreMovieController();
	 * tmc.addTheatreMovie(tm);
	 * 
	 * return true; }
	 */

	@GetMapping("/screens/live")
	public List<Screen> retrieveLiveScreens()
	{
		List<Screen> lst = repo.findAll();
		List<Screen> lstRes = new ArrayList<Screen>();
		LocalDate d = java.time.LocalDate.now(); 
		java.util.Date date = new java.util.Date();
		java.util.Date date1 = new java.util.Date();
		date.setDate(d.getDayOfMonth());
		date.setMonth(d.getDayOfMonth());
		date.setYear(d.getYear());
		
		for(Screen s:lst)
		{
			java.util.Date Sdate1 = s.getShowDate();
			date1.setDate(Sdate1.getDate());
			date1.setMonth(Sdate1.getMonth());
			date1.setYear(Sdate1.getYear());
			if(date.before(date1))
			{
				continue;
			}
			lstRes.add(s);					
		}
		return lstRes;
	}
	
	@PatchMapping("/booking/{id}/count/{count}/user/{uid}")
	public boolean bookTickets(@PathVariable long id, @PathVariable int count, @PathVariable long uid) {
		Optional<Screen> ops = repo.findById(id);
		if (!ops.isEmpty()) {
			Screen s = ops.get();
			int value = s.getOccupiedCapacity();
			if (s.getCapacity() - value >= count) {
				value = value + count;
			}
			s.setOccupiedCapacity(value);

			HashMap<String, Long> uriVariables = new HashMap<>();
			uriVariables.put("sid", id);
			uriVariables.put("count", (long) count);
			uriVariables.put("uid", uid);

			ResponseEntity<usersHistory> body = new RestTemplate().postForEntity(
					"http://localhost:8300/change/user/{uid}/screen/{sid}/count/{count}", null, usersHistory.class,
					uriVariables);

			/*
			 * usersHistory uh = restTemplate.patchForObject
			 * ("http://USERS-SERVICE/change/user/2/screen/{sid}/count/{count}", null,
			 * usersHistory.class, uriVariables );
			 */

			if (repo.save(s) != null) {
				return true;
			}

		}
		return false;
	}

	@GetMapping("/theatre/LoadBalanceTest")
	public TheatreEnvironment getEnvironment() {
		TheatreEnvironment te = new TheatreEnvironment();

		String port = env.getProperty("local.server.port");
		te.setEnvironment(port);
		return te;
	}
}
