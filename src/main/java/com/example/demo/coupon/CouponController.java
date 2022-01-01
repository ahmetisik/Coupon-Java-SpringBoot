package com.example.demo.coupon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "coupon")
public class CouponController {

    private final CouponService couponService;

    @Autowired
    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    @GetMapping
    public List<Coupon> getCoupons(){
        return couponService.getCoupons();
    }

    @GetMapping(path = "/active")
    public List<Coupon> getActiveCoupon() { return couponService.getActiveCoupon(); }

    @GetMapping(path = "{couponEan}")
    public Coupon getCouponByEan(@PathVariable("couponEan") Long couponEan) { return couponService.getCouponByEan(couponEan); }

    @PostMapping
    public void regiserNewCoupon(@RequestBody Coupon coupon){ couponService.addNewCoupon(coupon); }

    @DeleteMapping(path = "{couponId}")
    public void deleteCoupon(@PathVariable("couponId") Long couponId) {
        couponService.deleteCoupon(couponId);
    }

    @PutMapping(path = "{couponId}")
    public void updateCoupon(
            @PathVariable Long couponId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Double discount,
            @RequestParam(required = false) LocalDate startDate,
            @RequestParam(required = false) LocalDate endDate){
        couponService.updateCoupon(couponId, name, discount, startDate, endDate);
    }

}
