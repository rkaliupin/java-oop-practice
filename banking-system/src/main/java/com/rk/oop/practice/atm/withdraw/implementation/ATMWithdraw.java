package com.rk.oop.practice.atm.withdraw.implementation;

import com.rk.oop.practice.atm.ATM;
import com.rk.oop.practice.atm.bills.*;
import com.rk.oop.practice.atm.withdraw.handlers.BaseBillHandler;
import com.rk.oop.practice.atm.withdraw.request.WithdrawRequest;

import java.util.ArrayList;
import java.util.Arrays;

public class ATMWithdraw {
    private ATM atm;

    public ATMWithdraw(ATM atm) {
        this.atm = atm;
    }

    private BaseBillHandler getBillHandlersBaseChain() {
        ArrayList<Bill> billChain = new ArrayList<Bill>(Arrays.asList(HundredBill.getInstance(), FiftyBill.getInstance(), TwentyBill.getInstance(), TenBill.getInstance(), FiveBill.getInstance(), OneBill.getInstance()));
        BaseBillHandler billHandlerChain = new BaseBillHandler(billChain.get(0));
        BaseBillHandler nextHandler = billHandlerChain;

        for (int i = 1; i < billChain.size(); i += 1) {
            Bill bill = billChain.get(i);
            BaseBillHandler newHandler = new BaseBillHandler(bill);

            nextHandler.setNext(newHandler);
            nextHandler = newHandler;
        }

        return billHandlerChain;
    }

    public ArrayList<Bill> withdraw(int totalToWithdraw) {
        if (this.atm.getCardBalance() < totalToWithdraw) return null;

        BaseBillHandler billHandler = this.getBillHandlersBaseChain();
        WithdrawRequest withdrawRequest = new WithdrawRequest(totalToWithdraw, this.atm);

        billHandler.execute(withdrawRequest);

        return withdrawRequest.getBills();
    }
}
