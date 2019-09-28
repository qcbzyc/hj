package com.cslg.bean;

public class Car {
    private String color;
    private Boolean ac;

    public Car() {
    }

    public Car(String color, Boolean ac) {
        this.color = color;
        this.ac = ac;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getAc() {
        return ac;
    }

    public void setAc(Boolean ac) {
        this.ac = ac;
    }
}
