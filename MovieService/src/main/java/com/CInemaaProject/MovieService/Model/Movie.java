package com.CInemaaProject.MovieService.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="movie")
public class Movie {
	@Id
	@Column(name="movieid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="moviename")
	private String name;
	@Column(name="genre")
	private String genre;
	
	public Movie()
	{
		
	}
	
	//@OneToMany(mappedBy="Movie",cascade=CascadeType.ALL)
	//private List<Theatremovie> theatreMovie;
	
	
	public Movie(long id, String name, String genre) {
		super();
		this.id = id;
		this.name = name;
		this.genre = genre;
	}
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getGenre() {
		return genre;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
}
