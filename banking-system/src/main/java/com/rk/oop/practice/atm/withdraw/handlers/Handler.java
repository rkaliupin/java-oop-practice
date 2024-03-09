package com.rk.oop.practice.atm.withdraw.handlers;

import com.rk.oop.practice.atm.withdraw.request.WithdrawRequest;

public interface Handler {
    public void setNext(Handler handler);
    public boolean execute(WithdrawRequest request);
}
