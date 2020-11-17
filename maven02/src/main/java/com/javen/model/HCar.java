package com.javen.model;

import java.util.Date;

public class HCar {
	
	private Integer id;
	private String model;
	private Double displacement;
	private Integer produceYear;
	private Integer user;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Double getDisplacement() {
		return displacement;
	}
	public void setDisplacement(Double displacement) {
		this.displacement = displacement;
	}
	public Integer getProduceYear() {
		return produceYear;
	}
	public void setProduceYear(Integer produceYear) {
		this.produceYear = produceYear;
	}
	public Integer getUser() {
		return user;
	}
	public void setUser(Integer user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "HCar [id=" + id + ", model=" + model + ", displacement=" + displacement + ", produceYear=" + produceYear
				+ ", user=" + user + "]";
	}



	
}
