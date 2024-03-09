package com.rk.oop.practice.atm.bills;

public class TenBill extends Bill {
    private static TenBill tenBill;

    private TenBill() {
        this.value = 10;
    }

    public static TenBill getInstance() {
        if (tenBill == null) {
            tenBill = new TenBill();
        }
        return tenBill;
    }
}
