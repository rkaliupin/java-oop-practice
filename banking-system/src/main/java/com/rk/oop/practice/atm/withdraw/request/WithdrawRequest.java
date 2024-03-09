package com.rk.oop.practice.atm.withdraw.request;

import com.rk.oop.practice.atm.ATM;
import com.rk.oop.practice.atm.bills.Bill;
import com.rk.oop.practice.atm.bills.BillCollection;

import java.util.ArrayList;
import java.util.HashMap;

public class WithdrawRequest {
    private Integer targetAmount;
    private Integer remainAmount;
    private ArrayList<Bill> bills;
    private ATM atm;

    public WithdrawRequest(Integer targetAmount, ATM atm) {
        this.targetAmount = targetAmount;
        this.remainAmount = targetAmount;
        this.bills = new ArrayList<>();
        this.atm = atm;
    }

    public Integer getTargetAmount() {
        return this.targetAmount;
    }

    public void addBill(Bill bill) {
        this.remainAmount -= bill.getValue();
        this.bills.add(bill);
    }

    public ArrayList<Bill> getBills() {
        return this.bills;
    }

    public Integer getRemainAmount() {
        return this.remainAmount;
    }

    public HashMap<Bill, BillCollection> getAtmBills() {
        return this.atm.getAvailableBills();
    }
}
