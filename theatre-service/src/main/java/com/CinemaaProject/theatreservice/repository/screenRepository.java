package com.CinemaaProject.theatreservice.repository;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CinemaaProject.theatreservice.model.Screen;

@ComponentScan
@Repository
@Transactional
public interface screenRepository extends JpaRepository<Screen, Long>{
	
	//List<Screen> findByTheatreId(@Param("id") Long id);
	
	//@Query("Select s from Screen s where s.theatreid = :id")
	//List<Screen> findByTheaId(@Param("id") Long id);
	
	List<Screen> findByTheatreId(long id);
	
	List<Screen> findByShowDate(Date date);
	
	List<Screen> findByShowTime(Time time);
}
