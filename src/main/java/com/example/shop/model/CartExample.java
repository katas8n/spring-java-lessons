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
public class CartExample {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "cart_order", // name of the third table ( that will be created underneath a hood )
            joinColumns = @JoinColumn(name = "cart_id"), // First columns foreign key
            inverseJoinColumns = @JoinColumn(name = "order_id") // Second columns foreign key
    )
    private Set<OrderExample> orders = new HashSet<>();
}
