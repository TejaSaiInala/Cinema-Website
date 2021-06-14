package com.CinemaProject.usersservice;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.CinemaProject.usersservice.model.Screen;
import com.CinemaProject.usersservice.model.Theatremovie;
import com.CinemaProject.usersservice.model.userLogin;
import com.CinemaProject.usersservice.model.users;
import com.CinemaProject.usersservice.repository.userHistoryRepository;
import com.CinemaProject.usersservice.repository.usersRepository;

@RestController
public class usersController {

	@Autowired
	private usersRepository userRepo;
	
	@Autowired
	private userHistoryRepository uHisRepo;
		
	//private RestTemplate restTemplate = UsersServiceApplication.getRestTemplate();
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/users")
	public List<users> fetchUsers() 
	{
		return userRepo.findAll();
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/createUser")
	public users createUser(@RequestBody users user)
	{
		user.setPhoneNumber("2223334444");
		user.setRole("user");
		return userRepo.save(user);
	}
	
	@PostMapping("/createAdmin")
	public String createAdmin(@Valid @RequestBody users user)
	{
		user.setRole("admin");
		userRepo.save(user);
		return "Success";
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable long id)
	{
		userRepo.deleteById(id);
		return "Done";
	}
	
	@GetMapping("/user/{id}")
	public Optional<users> getUser(@PathVariable long id)
	{
		return userRepo.findById(id);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/login")
	public userLogin loginUser(@RequestBody users user)
	{
		userLogin ul=new userLogin();
		
		if(user.getEmail() != null && user.getPassword() != null)
		{
			Optional<users> u = userRepo.findByEmail(user.getEmail());
			try {
				users data = u.get();
				if(user.getPassword().equals(data.getPassword()))
				{
					ul.setEmail(user.getEmail());
					ul.setPassword(user.getPassword());
					ul.setError("");
					return ul;
				}
				else
				{
					ul.setError("Wrong Password");
					return ul;
				}
			}
			catch(Exception e)
			{
				ul.setError("Email doesn't exist");
				return ul;
			}
		}
		
		return ul; 
	}
	
	
	/*
	 * @PatchMapping("/change/user/{uid}/screen/{sid}/count/{c}")
	 * 
	 * @ResponseBody public userHistory userHistoryChange(@PathVariable long
	 * uid, @PathVariable long sid,
	 * 
	 * @PathVariable long c) { HashMap<String, Long> uriVariables = new HashMap<>();
	 * userHistory uh = new userHistory();
	 * 
	 * uriVariables.put("sid", sid);
	 * 
	 * ResponseEntity<Theatremovie[]> responseEntityTM = restTemplate
	 * .getForEntity("http://localhost:8000/theatre/screen/{sid}",
	 * Theatremovie[].class,uriVariables); Theatremovie[] ans =
	 * responseEntityTM.getBody();
	 * 
	 * Theatremovie tm = ans[0];
	 * 
	 * ResponseEntity<Screen> responseEntity = restTemplate
	 * .getForEntity("http://localhost:8000/screen/{sid}",
	 * Screen.class,uriVariables); Screen body = responseEntity.getBody();
	 * 
	 * //Calendar today = Calendar.getInstance(); LocalDateTime now =
	 * LocalDateTime.now(); Date d = new
	 * Date(now.getYear(),now.getMonthValue(),now.getDayOfMonth());
	 * 
	 * 
	 * Date date = new Date(body.getShowDate().getYear(),
	 * body.getShowDate().getMonth(), body.getShowDate().getDate()); Time time = new
	 * Time(body.getShowTime().getHours(), body.getShowTime().getMinutes(),
	 * body.getShowTime().getSeconds()); int y = now.getDayOfMonth();
	 * uh.setUserId(uid); uh.setScreenId(sid); uh.setTheatreId(body.getTheatreId());
	 * uh.setShowDate(date); uh.setShowTime(time); uh.setMovieId(tm.getMovieId());
	 * uh.setTicketsPurchased(c); uh.setPurchasedOn(d);
	 * 
	 * return uHisRepo.save(uh); }
	 */
}
