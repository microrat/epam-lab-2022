package com.example.project.entity;

import java.util.Date;

public class Order extends Entity{
    private Long user_id;
    private Long car_id;
    private String passport;
    private Date dateStart;
    private int term;
    private String status;
    private String rejectReason;
    private float cost;
    private float carDayPrice;

    public float getCarDayPrice() {
        return carDayPrice;
    }

    public void setCarDayPrice(float carDayPrice) {
        this.carDayPrice = carDayPrice;
    }



    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getCar_id() {
        return car_id;
    }

    public void setCar_id(Long car_id) {
        this.car_id = car_id;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    public float getCost() {
        return cost;
    }

    public void setCost() {
        this.cost = this.carDayPrice*this.term;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }


}
