// mysql> CREATE TABLE users ( id int auto_increment primary key, name varchar(22) );
//        Query OK, 0 rows affected (0.10 sec)
//
//        mysql> CREATE TABLE accounts ( id int auto_increment primary key, user_id int unique, balance int, FOREIGN KEY(user_id) REFERENCES users(id) ON DELETE CASCADE);
//        Query OK, 0 rows affected (0.10 sec)

package com.example.shop.model;

import jakarta.persistence.*;

@Entity
public class UserExample {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id") // There is pointed to the Foreing key
    private AccountExample accountExample;
}
