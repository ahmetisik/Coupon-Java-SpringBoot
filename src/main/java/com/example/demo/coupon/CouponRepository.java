package com.example.demo.coupon;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {

    // SELECT * FROM coupon WHERE email = ?
    @Query("SELECT c FROM Coupon c WHERE c.name = ?1")
    Optional<Coupon> findCouponByName(String name);

    @Query("SELECT c FROM Coupon c WHERE (c.id + 9810000000000) = ?1")
    Optional<Coupon> findCouponByEan(Long ean);


}
