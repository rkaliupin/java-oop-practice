package com.rk.oop.practice.atm;

import com.rk.oop.practice.atm.bills.*;
import com.rk.oop.practice.atm.card.Card;
import com.rk.oop.practice.atm.state.ATMState;
import com.rk.oop.practice.atm.state.CardInsertedState;
import com.rk.oop.practice.atm.state.IdleState;
import com.rk.oop.practice.atm.withdraw.implementation.ATMWithdraw;

import java.nio.Buffer;
import java.util.ArrayList;
import java.util.HashMap;

public class ATM {
    private final HashMap<Bill, BillCollection> availableBills;
    ATMState currentState;
    ATMWithdraw atmWithdraw;
    Card card;

    public ATM() {
        // Load available bills
        OneBill oneBill = OneBill.getInstance();
        BillCollection oneBillCollection = new BillCollection(oneBill, 8);
        FiveBill fiveBill = FiveBill.getInstance();
        BillCollection fiveBillCollection = new BillCollection(fiveBill, 13);
        TenBill tenBill = TenBill.getInstance();
        BillCollection tenBillCollection = new BillCollection(tenBill, 12);
        TwentyBill twentyBill = TwentyBill.getInstance();
        BillCollection twentyBillCollection = new BillCollection(twentyBill, 8);
        FiftyBill fiftyBill = FiftyBill.getInstance();
        BillCollection fiftyBillCollection = new BillCollection(fiftyBill, 4);
        HundredBill hundredBill = HundredBill.getInstance();
        BillCollection hundredBillCollection = new BillCollection(hundredBill, 4);

        this.availableBills = new HashMap<Bill, BillCollection>();
        this.availableBills.put(oneBill, oneBillCollection);
        this.availableBills.put(fiveBill, fiveBillCollection);
        this.availableBills.put(tenBill, tenBillCollection);
        this.availableBills.put(twentyBill, twentyBillCollection);
        this.availableBills.put(fiftyBill, fiftyBillCollection);
        this.availableBills.put(hundredBill, hundredBillCollection);
        //
        
        this.setState(new IdleState(this));
        this.atmWithdraw = new ATMWithdraw(this);
    }

    public Integer checkBalance() {
        return this.currentState.checkBalance();
    }
    public ArrayList<Bill> withdrawCash(int amountToWithdraw) {
        if (this.card == null || this.card.getBalance() < amountToWithdraw) return null;
        return this.currentState.withdrawCash(amountToWithdraw);
    }
    public void transferMoney() {
        this.currentState.transferMoney();
    }
    public Card returnCard() {
        return this.currentState.returnCard();
    }
    public Boolean insertCard(Card card) {
        return this.currentState.insertCard(card);
    }
    public void exit() {
        this.setState(new CardInsertedState(this));
    }

    public Boolean insertCardImp(Card card) {
        this.card = card;
        return true;
    }
    public Card returnCardImp() {
        Card card = this.card;
        this.card = null;
        return card;
    }
    public Integer checkBalanceImp() {
        System.out.println("Balance: ");
        System.out.println(this.card.getBalance());
        System.out.println("\n");
        return this.card.getBalance();
    }
    public void transferMoneyImp() {
        System.out.println("TBD Transfer Money");
        System.out.println("\n");
    }
    public ArrayList<Bill> withdrawCashImp(int amountToWithdraw) {
        ArrayList<Bill> withdrawBills = this.atmWithdraw.withdraw(amountToWithdraw);

        System.out.println("Withdraw Bills:");
        withdrawBills.forEach(bill -> {
            System.out.println(bill.getValue());
        });
        System.out.println("\n");

        return withdrawBills;
    }

    public HashMap<Bill, BillCollection> getAvailableBills() {
        return this.availableBills;
    }
    public void setState(ATMState atmState) {
        this.currentState = atmState;
    }
    public Integer getCardBalance() {
        return this.card != null ? this.card.getBalance() : 0;
    }
}
