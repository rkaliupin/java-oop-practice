package com.rk.oop.practice.atm.state;

import com.rk.oop.practice.atm.ATM;
import com.rk.oop.practice.atm.bills.Bill;
import com.rk.oop.practice.atm.card.Card;

import java.util.ArrayList;

public class TransferMoneyState implements ATMState {
    private ATM atm;

    public TransferMoneyState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public Integer checkBalance() {
        return null;
    }

    @Override
    public ArrayList<Bill> withdrawCash(int amountToWithdraw) {
        return null;
    }

    @Override
    public void transferMoney() {
        this.atm.transferMoneyImp();
    }

    @Override
    public Card returnCard() {
        return this.atm.returnCardImp();
    }

    @Override
    public Boolean insertCard(Card card) {
        return null;
    }

    @Override
    public void exit() {
        // Return card if it wasn't returned and clear any customer data.
        this.atm.returnCardImp();
    }
}
