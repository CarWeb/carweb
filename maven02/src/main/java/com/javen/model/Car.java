package com.javen.model;

public class Car  {
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

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
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

	@Override
	public String toString() {
		return "Car [id=" + id + ", model=" + model + ", displacement=" + displacement + ", produceYear=" + produceYear
				+ ", user=" + user + "]";
	}
    
}