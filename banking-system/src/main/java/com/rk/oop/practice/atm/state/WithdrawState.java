package com.rk.oop.practice.atm.state;

import com.rk.oop.practice.atm.ATM;
import com.rk.oop.practice.atm.bills.Bill;
import com.rk.oop.practice.atm.card.Card;
import com.rk.oop.practice.atm.withdraw.request.WithdrawRequest;

import java.util.ArrayList;

public class WithdrawState implements ATMState {
    private ATM atm;

    public WithdrawState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public Integer checkBalance() {
        return null;
    }

    @Override
    public ArrayList<Bill> withdrawCash(int amountToWithdraw) {
        return this.atm.withdrawCashImp(amountToWithdraw);
    }

    @Override
    public void transferMoney() {

    }

    @Override
    public Card returnCard() {
        return this.atm.returnCard();
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
