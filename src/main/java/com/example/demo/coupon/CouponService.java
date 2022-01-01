package com.example.demo.coupon;

import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CouponService {

    private final CouponRepository couponRepository;

    @Autowired
    public CouponService(CouponRepository couponRepository){
        this.couponRepository = couponRepository;
    }

    //ruft alle Coupons ab
    public List<Coupon> getCoupons(){
        return couponRepository.findAll();
    }

    //ruft alle aktiven Coupons ab
    public List<Coupon> getActiveCoupon() {
        return couponRepository.findAll()
                .stream().filter(Coupon::getStatus).collect(Collectors.toList());
    }

    //ruft Coupon anhand der EAN
    public Coupon getCouponByEan(Long couponEan) {
        return couponRepository.findCouponByEan(couponEan).orElseThrow(
                () -> new IllegalStateException("Coupon mit der EAN " + couponEan + " existiert nicht!")
        );
    }

    //legt einen neuen Coupon an
    public void addNewCoupon(Coupon coupon) {
        Optional<Coupon> couponOptional = couponRepository.findCouponByName(coupon.getName());
        if(couponOptional.isPresent()) {
            throw new IllegalStateException("Coupon mit dem gleichen Namen existiert bereits!");
        }
        couponRepository.save(coupon);
    }

    //löscht ein Coupon anhand seiner Id
    public void deleteCoupon(Long couponId) {
        boolean exists = couponRepository.existsById(couponId);
        if(!exists) {
            throw new IllegalStateException("Coupon mit der Id " + couponId + " existiert nicht!");
        }
        couponRepository.deleteById(couponId);
    }

    //verändert ein bestehendes Coupon. Wip: Dates
    @Transactional
    public void updateCoupon(Long couponId, String name, Double discount, LocalDate startDate, LocalDate endDate) {
        Coupon coupon = couponRepository.findById(couponId).orElseThrow(
                () -> new IllegalStateException("Coupon mit der Id " + couponId + " existiert nicht!")
        );

        if(name != null &&
                name.length() > 0 &&
                !Objects.equals(coupon.getName(), name)) {
            Optional<Coupon> couponOptional = couponRepository.findCouponByName(name);
            if(couponOptional.isPresent()) {
                throw new IllegalStateException("Coupon mit dem gleichen Namen existiert bereits!");
            }
            coupon.setName(name);
        }
        if(discount != null && !discount.isNaN()) coupon.setDiscount(discount);
        if(startDate != null) coupon.setStartDate(startDate);
        if(endDate != null) coupon.setEndDate(endDate);
    }

}
