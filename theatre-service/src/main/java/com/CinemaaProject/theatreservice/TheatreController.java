package com.CinemaaProject.theatreservice;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.CinemaaProject.theatreservice.model.Screen;
import com.CinemaaProject.theatreservice.model.Theatre;
import com.CinemaaProject.theatreservice.model.usersHistory;
import com.CinemaaProject.theatreservice.repository.screenRepository;
import com.CinemaaProject.theatreservice.repository.theatreRepository;

@Controller
public class TheatreController {

	@Autowired
	screenRepository repo;
	
	@Autowired
	theatreRepository Trepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/theatres")
	@ResponseBody
	public List<Theatre> retrieveTheatres(Model model)
	{
		//model.addAttribute("message", "controller nundi sending");
		//return Trepo.findAll();
		//model.addAttribute("List",Trepo.findAll());
		//return "thu";
		return Trepo.findAll();
	}
	
	@GetMapping("/theatre/{id}")
	@ResponseBody
	public Optional<Theatre> retrieveTheatreInforById(@PathVariable long id)
	{
		return Trepo.findById(id);
	}
	
	@PostMapping("theatre/register")
	public String registerTheatre(@RequestBody Theatre thea)
	{
		Trepo.save(thea);
		return "Success";
	}
	
	@GetMapping("screen/{id}")
	@ResponseBody
	public Optional<Screen> retrieveScreenforTheatre(@PathVariable long id)
	{
		return repo.findById(id);
	}
	
	@GetMapping("screens")
	@ResponseBody
	public List<Screen> retrieveAllScreens()
	{
		return repo.findAll();
	}
	
	@GetMapping("theatre/{id}/screens")
	@ResponseBody
	public List<Screen> retrieveScreensByTheatreID(@PathVariable long id)
	{
		return repo.findByTheatreId(id);
	}
	
	@PatchMapping("/booking/{id}/count/{count}")
	@ResponseBody
	public boolean bookTickets(@PathVariable long id, @PathVariable int count)
	{
		Optional<Screen> ops = repo.findById(id);
		if(!ops.isEmpty())
		{
			Screen s = ops.get();
			int value = s.getOccupiedCapacity();
			if(s.getCapacity() - value >= count)
			{
				value = value+count;
			}
			s.setOccupiedCapacity(value);			
			
			HashMap<String, Long> uriVariables = new HashMap<>();
			uriVariables.put("sid",id);
			uriVariables.put("count",(long) count);
			
			ResponseEntity<usersHistory> body = new RestTemplate()
					.postForEntity("http://localhost:8300/change/user/2/screen/{sid}/count/{count}",
					null, usersHistory.class, uriVariables);
			
			/* usersHistory uh = restTemplate.patchForObject
			 * ("http://USERS-SERVICE/change/user/2/screen/{sid}/count/{count}", null,
			 * usersHistory.class, uriVariables );
			 */
			
			if(repo.save(s) != null)
			{
				return true;
			}
			
		}
		return false;
	}
	
	
	
}
