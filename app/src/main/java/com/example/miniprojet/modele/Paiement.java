package com.example.miniprojet.modele;

import java.util.Date;

public class Paiement {
    private Date startDate;
    private Date expirationDate;
    private float amount;
    Subscription mSubscription;

    public Paiement() {
    }

    public Paiement(Date startDate, Date expirationDate, float amount, Subscription subscription) {
        this.startDate = startDate;
        this.expirationDate = expirationDate;
        this.amount = amount;
        mSubscription = subscription;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Subscription getSubscription() {
        return mSubscription;
    }

    public void setSubscription(Subscription subscription) {
        mSubscription = subscription;
    }
}
