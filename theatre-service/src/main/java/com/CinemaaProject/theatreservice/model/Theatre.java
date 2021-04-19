package com.CinemaaProject.theatreservice.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="theatres")
public class Theatre {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="theatreid")
	private long theatreId;
	@Column(name="theatrename")
	private String name;
	
//	@OneToMany(mappedBy="Theatre", cascade=CascadeType.ALL)
//	private List<Screen> screens;
//	//@JoinColumn(name="theatreid",referencedColumnName="theatreid")
//	
//	@OneToMany(mappedBy="Theatre", cascade=CascadeType.ALL)
//	private List<Theatremovie> theatreMovie;
	
	public Theatre()
	{
		
	}
	
	public Theatre(long id, String name) {
		super();
		this.theatreId = id;
		this.name = name;
	}

	public long getId() {
		return theatreId;
	}
	public void setId(long id) {
		this.theatreId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
