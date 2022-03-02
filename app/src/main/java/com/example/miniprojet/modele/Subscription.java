package com.example.miniprojet.modele;

import java.util.Arrays;
import java.util.List;

public class Subscription {
    User user;
    Service service;
    List<Paiement> paiements;
    public Subscription() {
    }

    public Subscription(User user, Service service, Paiement[] paiements) {
        this.user = user;
        this.service = service;
        this.paiements = Arrays.asList(paiements);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }



}
