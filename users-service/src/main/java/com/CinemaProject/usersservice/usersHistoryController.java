package com.CinemaProject.usersservice;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.CinemaProject.usersservice.model.Screen;
import com.CinemaProject.usersservice.model.Theatremovie;
import com.CinemaProject.usersservice.model.usersHistory;
import com.CinemaProject.usersservice.repository.userHistoryRepository;

@RestController
public class usersHistoryController {

	@Autowired
	private userHistoryRepository uHisRepo;
	
	/*
	 * @Autowired private RestTemplate restTemplate;
	 */
	
	@PostMapping("/change/user/{uid}/screen/{sid}/count/{c}")
	//@ResponseBody
	public usersHistory saveUsersHistory(@PathVariable long uid, 
			@PathVariable long sid, @PathVariable long c)
	{
		HashMap<String, Long> uriVariables = new HashMap<>();
		usersHistory uh = new usersHistory();
		
		uriVariables.put("sid", sid);
		
		ResponseEntity<Theatremovie[]> responseEntityTM = new RestTemplate()
				.getForEntity("http://localhost:8000/theatre/screen/{sid}", 
						 Theatremovie[].class,uriVariables);
		Theatremovie[] ans = responseEntityTM.getBody();
		
		Theatremovie tm = ans[0];
		
		ResponseEntity<Screen> responseEntity = new RestTemplate()
				.getForEntity("http://localhost:8000/screen/{sid}", 
						 Screen.class,uriVariables);
		Screen body = responseEntity.getBody();	
		
		//Calendar today = Calendar.getInstance();
		LocalDateTime now = LocalDateTime.now();
		Date d = new Date(now.getYear(),now.getMonthValue(),now.getDayOfMonth());

		int y = now.getYear();
		uh.setUserId(uid);
		uh.setScreenId(sid);
		uh.setCount(c);
		uh.setPurchasedOn(d);
	
		return uHisRepo.save(uh);
	}
	
	@GetMapping("/userHistory/{id}")
	//@ResponseBody
	public List<usersHistory> retrieveUsersHistoryByUserId(@PathVariable long id)
	{
		return uHisRepo.findByUserId(id);
	}
	
	
}
