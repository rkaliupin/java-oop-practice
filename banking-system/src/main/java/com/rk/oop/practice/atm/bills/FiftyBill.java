package com.rk.oop.practice.atm.bills;

public class FiftyBill extends Bill {
    private static FiftyBill fiftyBill;
    private FiftyBill() {
        this.value = 50;
    }

    public static FiftyBill getInstance() {
        if (fiftyBill == null) {
            fiftyBill = new FiftyBill();
        }
        return fiftyBill;
    }
}
