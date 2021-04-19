package com.CinemaaProject.theatreservice.model;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.CinemaaProject.theatreservice.repository.theatreMovieRepository;

public abstract class theatreMovieRepoImpl implements theatreMovieRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	/*
	 * public List<Theatremovie> findByTheatreId(long id) { Query query =
	 * entityManager.createNativeQuery("select * from theatrescreenmovie where " +
	 * "theatreid =" , Theatremovie.class);
	 * 
	 * query.setParameter(1, id);
	 * 
	 * return query.getResultList(); }
	 */
}
