package com.rk.oop.practice.atm;

import com.rk.oop.practice.atm.card.Card;

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM();
        Card card = new Card("4111111", "05/29", "543", 123);

        atm.insertCard(card);
        atm.checkBalance();
        atm.exit();
        atm.withdrawCash(45);
    }
}