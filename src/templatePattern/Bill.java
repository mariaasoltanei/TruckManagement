package templatePattern;

import strategyPattern.PaymentStrategy;

import java.time.LocalDate;

public class Bill {
    private LocalDate billDate;
    private double amount;

    public Bill(LocalDate billDate, double amount) {
        this.billDate = billDate;
        this.amount = amount;
        //this.paymentStrategy = paymentStrategy;
    }

    public void setBillDate(LocalDate billDate) {
        this.billDate = billDate;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void pay(PaymentStrategy paymentStrategy){
        paymentStrategy.pay(this.amount);
    }
}
