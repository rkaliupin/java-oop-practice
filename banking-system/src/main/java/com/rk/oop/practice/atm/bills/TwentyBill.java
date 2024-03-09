package com.rk.oop.practice.atm.bills;

public class TwentyBill extends Bill {
    private static TwentyBill twentyBill;

    private TwentyBill() {
        this.value = 20;
    }

    public static TwentyBill getInstance() {
        if (twentyBill == null) {
            twentyBill = new TwentyBill();
        }
        return twentyBill;
    }
}
