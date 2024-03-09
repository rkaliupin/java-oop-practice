package com.rk.oop.practice.atm.bills;

public class FiveBill extends Bill {
    private static FiveBill fiveBill;

    private FiveBill() {
        this.value = 5;
    }

    public static FiveBill getInstance() {
        if (fiveBill == null) {
            fiveBill = new FiveBill();
        }
        return fiveBill;
    }
}
