package com.rk.oop.practice.atm.bills;

public class BillCollection {
    private Bill bill;
    private int quantity;

    public BillCollection(Bill bill) {
        this.bill = bill;
        this.quantity = 0;
    }

    public BillCollection(Bill bill, int quantity) {
        this.bill = bill;
        this.quantity = quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public boolean removeBills(int quantity) {
        if (this.quantity - quantity < 0) return false;
        this.quantity -= quantity;
        return true;
    }

    public Bill getBill() {
        return this.bill;
    }
}
