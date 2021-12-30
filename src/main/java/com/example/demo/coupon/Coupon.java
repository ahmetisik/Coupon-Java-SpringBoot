package com.example.demo.coupon;

import java.time.LocalDate;

public class Coupon {

    private Long id;
    private Long ean; //13 stellig beginnt mit 981
    private String name;
    private LocalDate start;
    private LocalDate end;
    private double discount;
    private boolean status;

    public Coupon() {
    }

    public Coupon(Long id, String name, double discount) {
        this.id = id;
        this.name = name;
        this.discount = discount;
    }

    public Coupon(Long id, Long ean, String name, LocalDate start, LocalDate end, double discount, boolean status) {
        this.id = id;
        this.ean = ean;
        this.name = name;
        this.start = start;
        this.end = end;
        this.discount = discount;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEan() {
        return ean;
    }

    public void setEan(Long ean) {
        this.ean = ean;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "id=" + id +
                ", ean=" + ean +
                ", name='" + name + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", discount=" + discount +
                ", status=" + status +
                '}';
    }
}
