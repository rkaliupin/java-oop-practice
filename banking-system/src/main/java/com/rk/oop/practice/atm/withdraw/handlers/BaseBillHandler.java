package com.rk.oop.practice.atm.withdraw.handlers;

import com.rk.oop.practice.atm.bills.Bill;
import com.rk.oop.practice.atm.bills.BillCollection;
import com.rk.oop.practice.atm.bills.FiftyBill;
import com.rk.oop.practice.atm.withdraw.request.WithdrawRequest;

public class BaseBillHandler implements Handler {
    private final Bill baseBill;
    private Handler handler;

    public BaseBillHandler(Bill bill) {
        this.baseBill = bill;
    }

    @Override
    public void setNext(Handler handler) {
        this.handler = handler;
    }

    @Override
    public boolean execute(WithdrawRequest request) {
        int remainAmountIsPositive = request.getRemainAmount() - this.baseBill.getValue();
        int amountOfUsedBills = 1;
        BillCollection atmBillCollection = request.getAtmBills().get(this.baseBill);

        // ATM doesn't have a bill of this nominal
        if (atmBillCollection == null) return false;

        while (remainAmountIsPositive >= 0 && atmBillCollection.getQuantity() > 0) {
            request.addBill(this.baseBill);
            atmBillCollection.removeBills(1);

            remainAmountIsPositive = request.getRemainAmount() - this.baseBill.getValue();
        }

        if (request.getRemainAmount() == 0) return true;
        if (this.handler != null) return this.handler.execute(request);

        return false;
    }
}
