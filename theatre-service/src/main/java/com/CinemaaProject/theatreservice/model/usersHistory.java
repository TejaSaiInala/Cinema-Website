package com.CinemaaProject.theatreservice.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usershistory")
public class usersHistory {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="userid")
	private long userId;
	@Column(name="screenid")
	private long screenId;
	@Column(name="purchasedon")
	private Date purchasedOn;
	@Column(name="purchasedcount")
	private long count;
	
	
	public usersHistory()
	{}
	
	public usersHistory(long id, long userId, long screenId, Date purchasedOn, int count) {
		super();
		this.id = id;
		this.userId = userId;
		this.screenId = screenId;
		this.purchasedOn = purchasedOn;
		this.count = count;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getScreenId() {
		return screenId;
	}
	public void setScreenId(long screenId) {
		this.screenId = screenId;
	}
	public Date getPurchasedOn() {
		return purchasedOn;
	}
	public void setPurchasedOn(Date purchasedOn) {
		this.purchasedOn = purchasedOn;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	
}
