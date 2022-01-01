package com.example.demo.coupon;

import org.apache.tomcat.jni.Local;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class CouponConfig {

    @Bean
    CommandLineRunner commandLineRunner(CouponRepository repository) {
        return args -> {
            Coupon rewe = new Coupon(
                    "Rewe Coupon 5€",
                    5,
                    LocalDate.of(2020, Month.JANUARY, 1),
                    LocalDate.of(2021, Month.DECEMBER, 31)
            );

            Coupon mediamarkt = new Coupon(
                    "Mediamarkt Coupon 20€",
                    20,
                    LocalDate.of(2020, Month.JANUARY, 1),
                    LocalDate.of(2022, Month.DECEMBER, 31)

            );

            repository.saveAll(
                    List.of(rewe, mediamarkt)
            );

        };
    }

}
