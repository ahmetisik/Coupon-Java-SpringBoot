package com.example.demo.coupon;

import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Coupon {

    @Id
    @SequenceGenerator(
            name = "coupon_sequence",
            sequenceName = "coupon_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "coupon_sequence"
    )
    private Long id;
    private String name;
    private double discount;
    private LocalDate startDate;
    private LocalDate endDate;
    @Transient
    private Long ean;
    @Transient
    private boolean status;

    public Coupon() {
    }

    public Coupon(String name, double discount, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.discount = discount;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) { this.discount = discount; }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    //evtl verbessern. https://de.wikipedia.org/wiki/Global_Trade_Item_Number
    public Long getEan() {
         return 9810000000000L + this.id;
    }

    public void setEan(Long ean) {
        this.ean = ean;
    }

    public boolean getStatus() {
        LocalDate today = LocalDate.now();
        return today.isAfter(this.startDate) && today.isBefore(this.endDate);
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", discount=" + discount +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", ean=" + ean +
                ", status=" + status +
                '}';
    }
}
