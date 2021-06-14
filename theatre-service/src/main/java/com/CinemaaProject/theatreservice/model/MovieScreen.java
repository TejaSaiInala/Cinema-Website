package com.CinemaaProject.theatreservice.model;

public class MovieScreen {

	private String movieName;
	private String genre;
	private String showDate;
	private String showTime;
	private long TheatreId;
	private int seats;
	
	public MovieScreen()
	{
		
	}
	
	public MovieScreen(String movieName, String genre, String showDate, String showTime, long theatreId, int seats) {
		super();
		this.movieName = movieName;
		this.genre = genre;
		this.showDate = showDate;
		this.showTime = showTime;
		TheatreId = theatreId;
		this.seats = seats;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getShowDate() {
		return showDate;
	}
	public void setShowDate(String showDate) {
		this.showDate = showDate;
	}
	public String getShowTime() {
		return showTime;
	}
	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}
	public long getTheatreId() {
		return TheatreId;
	}
	public void setTheatreId(long theatreId) {
		TheatreId = theatreId;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	
	
}
