package com.CinemaaProject.theatreservice.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CinemaaProject.theatreservice.model.TheatreMovieIdentity;
import com.CinemaaProject.theatreservice.model.Theatremovie;

@Repository
//public interface theatreMovieRepository extends JpaRepository<Theatremovie,TheatreMovieIdentity>, theatreMovieRepoCustom {
//
//}
public interface theatreMovieRepository extends CrudRepository<Theatremovie,TheatreMovieIdentity>{
	
	List<Theatremovie> findByMovieId(long id);
	
	List<Theatremovie> findByTheatreId(long id);
	
	List<Theatremovie> findByScreenId(long id);
	
	//List<Theatremovie> findByshowTime(Date date);
}