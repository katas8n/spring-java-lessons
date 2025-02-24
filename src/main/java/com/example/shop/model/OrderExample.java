//  mysql> CREATE TABLE carts(id BIGINT AUTO_INCREMENT PRIMARY KEY);
//        Query OK, 0 rows affected (0.16 sec)
//
//        mysql> CREATE TABLE orders(id BIGINT AUTO_INCREMENT PRIMARY KEY);
//        Query OK, 0 rows affected (0.02 sec)
//
//        mysql> CREATE TABLE cart_order(id BIGINT AUTO_INCREMENT PRIMARY KEY, cart_id BIGINT, order_id BIGINT, FOREIGN KEY(cart_id) REFERENCES carts(id), FOREIGN KEY(order_id) REFERENCES orders(id));
//        Query OK, 0 rows affected (0.05 sec)

package com.example.shop.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class OrderExample {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "orders")
    private Set<OrderExample> carts = new HashSet<>();
}
