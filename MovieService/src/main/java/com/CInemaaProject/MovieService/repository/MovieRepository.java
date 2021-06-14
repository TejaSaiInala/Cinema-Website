package com.CInemaaProject.MovieService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CInemaaProject.MovieService.Model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{
	
	Movie findByName(String name);
	
}