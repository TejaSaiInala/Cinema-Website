package com.CinemaaProject.theatreservice.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

//@Embeddable
public class TheatreMovieIdentity implements Serializable {
 
	//private static final long serialVersionUID = 1L;
	
	//@Column(name="theatreid")
	private long theatreId;
	//@Column(name="screenid")
	private long screenId;
	//@Column(name="movieid")
	//private long movieId;
	//@Column(name="showtime")
	private Time showTime;
	private Date showDate;
	
	public TheatreMovieIdentity()
	{
		
	}
	
	public TheatreMovieIdentity(long theatreId, long screenId, Time showTime, Date showDate) {
		//long movieId,
		super();
		this.theatreId = theatreId;
		this.screenId = screenId;
		//this.movieId = movieId;
		this.showTime = showTime;
		this.showDate = showDate;
	}
	
	public long getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(long theatreId) {
		this.theatreId = theatreId;
	}
	public long getScreenId() {
		return screenId;
	}
	public void setScreenId(long screenId) {
		this.screenId = screenId;
	}

	/*
	 * public long getMovieId() { return movieId; } public void setMovieId(long
	 * movieId) { this.movieId = movieId; }
	 */
	public Time getShowTime() {
		return showTime;
	}
	public void setShowTime(Time showTime) {
		this.showTime = showTime;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + (int) (movieId ^ (movieId >>> 32));
		result = prime * result + (int) (screenId ^ (screenId >>> 32));
		result = prime * result + ((showTime == null) ? 0 : showTime.hashCode());
		result = prime * result + (int) (theatreId ^ (theatreId >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TheatreMovieIdentity other = (TheatreMovieIdentity) obj;
		//if (movieId != other.movieId)
			//return false;
		if (screenId != other.screenId)
			return false;
		if (showTime == null) {
			if (other.showTime != null)
				return false;
		} else if (!showTime.equals(other.showTime))
			return false;
		if (theatreId != other.theatreId)
			return false;
		return true;
	}
	
	
	
}
