package com.rk.oop.practice.atm.state;

import com.rk.oop.practice.atm.ATM;
import com.rk.oop.practice.atm.bills.Bill;
import com.rk.oop.practice.atm.card.Card;

import java.util.ArrayList;

public class CardInsertedState implements ATMState {
    private ATM atm;

    public CardInsertedState(ATM atm) {
        this.atm = atm;
    }
    @Override
    public Integer checkBalance() {
        this.atm.setState(new CheckBalanceState(this.atm));
        return this.atm.checkBalanceImp();
    }

    @Override
    public ArrayList<Bill> withdrawCash(int amountToWithdraw) {
        this.atm.setState(new WithdrawState(this.atm));
        return this.atm.withdrawCashImp(amountToWithdraw);
    }

    @Override
    public void transferMoney() {}

    @Override
    public Card returnCard() {
        return this.atm.returnCardImp();
    }

    @Override
    public Boolean insertCard(Card card) {
        return false;
    }

    @Override
    public void exit() {
        // Return card if it wasn't returned and clear any customer data.
        this.atm.returnCardImp();
    }
}
