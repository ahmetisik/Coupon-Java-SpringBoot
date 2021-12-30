package com.example.demo.coupon;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class CouponService {

    public List<Coupon> getCoupons(){
        return List.of(
                new Coupon(
                        1L,
                        9819876543210L,
                        "150€ Gutschein",
                        LocalDate.of(2020, Month.JANUARY, 5),
                        LocalDate.of(2021, Month.DECEMBER, 31),
                        150,
                        true
                )
        );
    }

}
