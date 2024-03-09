package com.rk.oop.practice.atm.state;

import com.rk.oop.practice.atm.bills.Bill;
import com.rk.oop.practice.atm.card.Card;

import java.util.ArrayList;

public interface ATMState {
    public Integer checkBalance();
    public ArrayList<Bill> withdrawCash(int amountToWithdraw);
    public void transferMoney();
    public Card returnCard();
    public Boolean insertCard(Card card);
    public void exit();
}
