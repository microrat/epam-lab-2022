package com.example.project.entity;

public class Refund extends Entity{
    private Long Order_id;
    private String damage;
    private float repair;

    public Long getOrder_id() {
        return Order_id;
    }

    public void setOrder_id(Long order_id) {
        Order_id = order_id;
    }

    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public float getRepair() {
        return repair;
    }

    public void setRepair(float repair) {
        this.repair = repair;
    }
}
