package com.CinemaaProject.theatreservice;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CinemaaProject.theatreservice.model.Screen;
import com.CinemaaProject.theatreservice.model.Theatremovie;
import com.CinemaaProject.theatreservice.repository.screenRepository;
import com.CinemaaProject.theatreservice.repository.theatreMovieRepository;


@Controller
@RequestMapping("/theatre")
public class theatreMovieController {

	@Autowired
	private theatreMovieRepository tRepo;
	
	@Autowired
	private screenRepository repo;
	
	@GetMapping("/{id}/movies")
	@ResponseBody
	public List<Theatremovie> getMovieforTheatre(@PathVariable long id)
	{
		return tRepo.findByTheatreId(id);
	}
	
	@GetMapping("/movies/{id}")
	@ResponseBody
	public List<Theatremovie> getAllforMovie(@PathVariable long id)
	{
		return tRepo.findByMovieId(id);
	}
	
	@GetMapping("/screen/{id}")
	@ResponseBody
	public List<Theatremovie> getMovieforScreen(@PathVariable long id)
	{
		return tRepo.findByScreenId(id);		
	}
	
	@GetMapping("/movies")
	@ResponseBody
	public List<Theatremovie> getAll()
	{
		return (List<Theatremovie>) tRepo.findAll();
		
	}
	
	@GetMapping("/showDate/{date}")
	@ResponseBody
	/*public List<Theatremovie> getAllByDate(@PathVariable("date") @DateTimeFormat(pattern= "yyyy-mm-dd") 
	Date dateVal)*/
	public List<Screen> getAllByDate(@PathVariable String date) 
	{
		//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

		//java.util.Date dt = formatter.parse(date);
		//java.sql.Date.valueOf(date);
		List<Screen> lsts = repo.findByShowDate(java.sql.Date.valueOf(date));
		return lsts;
	}
	
	@GetMapping("/{tid}/showDate/{date}")
	@ResponseBody
	public List<Screen> getAllByIdByDate(@PathVariable long tid,@PathVariable String date) 
	{
		List<Screen> res = new ArrayList<>();
		List<Screen> lsts = repo.findByShowDate(java.sql.Date.valueOf(date));
		for(Screen lst: lsts)
		{
			if(lst.getTheatreId() == tid)
			{
				res.add(lst);
			}
		}
		return res;
	}
	
	@GetMapping("/{tid}/showDate/{date}/showTime/{time}")
	@ResponseBody
	public List<Screen> getAllByTime(@PathVariable long tid,@PathVariable String date,@PathVariable String time) 
	{
		List<Screen> lsts = repo.findByShowDate(java.sql.Date.valueOf(date));
		List<Screen> res = new ArrayList<>();
		Time t,t1;
		
		for(Screen s:lsts)
		{
			t = s.getShowTime();
			t1 = java.sql.Time.valueOf(time);
			if(t.equals(t1) && s.getTheatreId() == tid)
			{
				res.add(s);
			}
		}

		return res;
	}
}

