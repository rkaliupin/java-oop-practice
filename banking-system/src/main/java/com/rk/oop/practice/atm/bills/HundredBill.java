package com.rk.oop.practice.atm.bills;

public class HundredBill extends Bill {
    private static HundredBill hundredBill;

    private HundredBill() {
        this.value = 100;
    }

    public static HundredBill getInstance() {
        if (hundredBill == null) {
            hundredBill = new HundredBill();
        }
        return hundredBill;
    }
}
