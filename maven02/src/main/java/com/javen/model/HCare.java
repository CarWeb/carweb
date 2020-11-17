package com.javen.model;

import java.util.Date;

public class HCare {
	
	private Integer id;
	private Integer mileage;;
	private Date careDate;
	private Integer careTimes;
	private Integer car;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMileage() {
		return mileage;
	}
	public void setMileage(Integer mileage) {
		this.mileage = mileage;
	}
	public Integer getCareTimes() {
		return careTimes;
	}
	public void setCareTimes(Integer careTimes) {
		this.careTimes = careTimes;
	}
	public Date getCareDate() {
		return careDate;
	}
	public void setCareDate(Date careDate) {
		this.careDate = careDate;
	}
	public Integer getCar() {
		return car;
	}
	public void setCar(Integer car) {
		this.car = car;
	}
	@Override
	public String toString() {
		return "HCare [id=" + id + ", mileAge=" + mileage + ", careDate=" + careDate + ", careTimes=" + careTimes
				+ ", car=" + car + "]";
	}
	
}
