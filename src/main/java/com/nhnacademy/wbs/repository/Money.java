package com.nhnacademy.wbs.repository;

public class Money {
    private final long amount;
    private final Currency currency;

    public Money(long amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public enum Currency {
        WON
    }
}
