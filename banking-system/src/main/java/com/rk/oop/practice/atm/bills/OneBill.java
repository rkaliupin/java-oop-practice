package com.rk.oop.practice.atm.bills;

public class OneBill extends Bill {
    private static OneBill oneBill;

    private OneBill() {
        this.value = 1;
    }

    public static OneBill getInstance() {
        if (oneBill == null) {
            oneBill = new OneBill();
        }
        return oneBill;
    }
}
