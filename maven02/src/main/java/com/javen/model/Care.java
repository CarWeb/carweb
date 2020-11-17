package com.javen.model;

public class Care {
    private Integer id;

    private Integer mileage;

    private Integer caretimes;

    private Integer car;

    private Integer caredate;

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

    public Integer getCaretimes() {
        return caretimes;
    }

    public void setCaretimes(Integer caretimes) {
        this.caretimes = caretimes;
    }

    public Integer getCar() {
        return car;
    }

    public void setCar(Integer car) {
        this.car = car;
    }

    public Integer getCaredate() {
        return caredate;
    }

    public void setCaredate(Integer caredate) {
        this.caredate = caredate;
    }

	@Override
	public String toString() {
		return "Care [id=" + id + ", mileage=" + mileage + ", caretimes=" + caretimes + ", car=" + car + ", caredate="
				+ caredate + "]";
	}
    
}