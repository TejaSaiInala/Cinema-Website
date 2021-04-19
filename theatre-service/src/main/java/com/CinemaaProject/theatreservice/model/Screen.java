package com.CinemaaProject.theatreservice.model;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="screens")
public class Screen {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="screenid")
	private long screenId;
	@Column(name="capacity")
	private int capacity;
	@Column(name="occupiedcapacity")
	private int occupiedCapacity;
	/*
	 * @Column(name="showsperday") private int showsPerDay;
	 */
	/*
	 * @Column(name="showtime") private Timestamp showDateTime;
	 */
	@Column(name="showdate")
	private Date showDate;
	@Column(name="showtime")
	private Time showTime;
	@Column(name="theatreid")
	private long theatreId;
	
//	@ManyToOne //( cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity=Theatre.class )
//	//@JoinColumn(name="theatreid", nullable=false)
//	@JoinTable(name="screens")
//	private Theatre Theatre;
//	
//	@OneToMany(mappedBy="Screen",cascade=CascadeType.ALL)
//	private List<Theatremovie> theatreMovie;
		
	//private Date showDate;
	
	//private Time showTime;
	public Screen()
	{
		
	}
	
	public Screen(long screenId, int capacity, int occupiedCapacity,
			long theatreId, Time showTime, Date showDate) {
		super();
		this.screenId = screenId;
		this.capacity = capacity;
		this.occupiedCapacity = occupiedCapacity;
		//this.showsPerDay = showsPerDay;
		this.showDate = showDate;
		this.showTime = showTime;
		//this.showDateTime = showDateTime;
		this.theatreId = theatreId;
	}
	
	public void setScreenId(long screenId) {
		this.screenId = screenId;
	}

	public Long getScreenId() {
		return screenId;
	}
	public void setScreenId(Long screenId) {
		this.screenId = screenId;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getOccupiedCapacity() {
		return occupiedCapacity;
	}
	public void setOccupiedCapacity(int occupiedCapacity) {
		this.occupiedCapacity = occupiedCapacity;
	}
	/*
	 * public int getShowsPerDay() { return showsPerDay; } public void
	 * setShowsPerDay(int showsPerDay) { this.showsPerDay = showsPerDay; }
	 */

	public Time getShowTime() { return showTime; } 
	
	public void setShowTime(Time
	  showTime) { this.showTime = showTime; }
	  
	public Date getShowDate() { return showDate; }
	  
	public void setShowDate(Date showDate) { this.showDate = showDate; }
	 
	
	/*
	 * public void setShowDateTime(Timestamp showDateTime) { this.showDateTime =
	 * showDateTime; }
	 
	
	public Timestamp getShowDateTime()
	{
		return showDateTime;
	}*/
	
	
	  public long getTheatreId() { return theatreId; } public void
	  setTheatreId(long theatreId) { this.theatreId = theatreId; }
	 
}
