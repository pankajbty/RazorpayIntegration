package com.in28minutes.springboot.basics.sprintbootin10steps.OrderEntry;

public class Order {

    private long amount;
    private String currency;
    private boolean payment_capture;

    public Order(long amount, String currency, boolean payment_capture) {
        this.amount = amount;
        this.currency = currency;
        this.payment_capture = payment_capture;
    }

    public long getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public boolean getPayment_capture() {
        return payment_capture;
    }

    @Override
    public String toString() {
        return "Order{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                ", payment_capture=" + payment_capture +
                '}';
    }
}

