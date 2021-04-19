package com.CinemaaProject.theatreservice.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.CinemaaProject.theatreservice.model.Theatremovie;

@Repository
//@Transactional//(readOnly = true)
public interface theatreMovieRepoCustom {

	//public List<Theatremovie> findByTheatreId(long id);
}
