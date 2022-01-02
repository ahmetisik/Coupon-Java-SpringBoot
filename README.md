# Coupon-Java-SpringBoot

Ein Webservice zur Verwaltung von Coupons mit Java und Spring Boot.

Per Webservice-Request können neue Coupons angelegt, verändert oder gelöscht werden.

### Endpoints

- **/coupon [GET]**
-> ruft alle Coupons ab

- **/coupon/active [GET]**
-> ruft alle aktiven Coupons ab

- **/coupon/{couponEan} [GET]**
-> ruft ein Coupon anhand der EAN

- **/coupon [POST]**
-> legt einen neuen Coupon an

- **/coupon/{couponId} [PUT]**
-> verändert ein bestehendes Coupon

- **/coupon/{couponId} [DELETE]**
-> löscht ein Coupon anhand seiner Id

