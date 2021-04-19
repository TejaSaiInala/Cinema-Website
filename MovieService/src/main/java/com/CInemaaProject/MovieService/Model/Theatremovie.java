package com.CInemaaProject.MovieService.Model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "theatrescreenmovie")
//@IdClass(TheatreMovieIdentity.class)
public class Theatremovie implements Serializable {

	/*
	 * @EmbeddedId private TheatreMovieIdentity id;
	 */
	
	/*
	 * @Id
	 * 
	 * 
	 */
	@Column(name="theatreid")
	private long theatreId;
	  
	  @Id 
	  @Column(name="screenid")
	  private long screenId;	  
	  
		/*
		 * @Id
		 * 
		 * @Column(name="showtime") private Timestamp showTime;
		 */
	 
	@Column(name="movieid")
	private long movieId;
	
	//@ManyToOne
	//@MapsId("movieId")
	//private Movie Movie;
	// @JoinTable(name="")

//	@ManyToOne
//	@MapsId("screenId")
//	private Screen Screen;
//
//	@ManyToOne
//	@MapsId("theatreId")
//	private Theatre Theatre;

	public Theatremovie() {

	}

//	public Theatremovie(TheatreMovieIdentity id, long movieId) {
//		super();
//		this.id = id;
//		this.movieId = movieId;
//	}

	
//	  public TheatreMovieIdentity getId() { return id; }
//	  
//	  public void setId(TheatreMovieIdentity id) { this.id = id; }
	 
	  public long getMovieId() { return movieId; }
	
	  public void setMovieId(long movieId) { this.movieId = movieId; }
	
	  public long getTheatreId() { return theatreId; }
	  
	  public void setTheatreId(long theatreId) { this.theatreId = theatreId; }
	  
	  public long getScreenId() { return screenId; }
	  
	  public void setScreenId(long screenId) { this.screenId = screenId; }
	  
	  
	  
		/*
		 * public Timestamp getShowTime() { return showTime; }
		 * 
		 * public void setShowTime(Timestamp showTime) { this.showTime = showTime; }
		 */
	  
	  
	  public Theatremovie(long theatreId, long screenId, long movieId)
	  { super(); this.theatreId = theatreId; this.screenId = screenId;
	  this.movieId = movieId;  }
	 

}
