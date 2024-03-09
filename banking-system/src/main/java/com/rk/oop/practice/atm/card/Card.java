package com.rk.oop.practice.atm.card;

public class Card {
    private String number;
    private String date;
    private String cvv;
    private Integer balance;

    public Card(String number, String date, String cvv, Integer balance) {
        this.number = number;
        this.date = date;
        this.cvv = cvv;
        this.balance = balance;
    }

    public String getNumber() {
        return number;
    }

    public String getDate() {
        return date;
    }

    public String getCvv() {
        return cvv;
    }

    public Integer getBalance() {
        return balance;
    }
}
