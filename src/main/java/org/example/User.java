package org.example;

import lombok.EqualsAndHashCode;

import java.util.Map;

@EqualsAndHashCode
public class User {

    private String id;
    private String name;
    private String address;
    private String email;
    private String phoneNumber;


    public void updateOderHistory(Map<Product, Integer> shoppingCart) {
        //TODO add implementation
    }

    public void sendNotification() {
        //TODO add implementation
    }
}
