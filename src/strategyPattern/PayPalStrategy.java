package strategyPattern;

import strategyPattern.PaymentStrategy;

public class PayPalStrategy implements PaymentStrategy {

    private String emailId;
    private String password;

    public PayPalStrategy(String email, String password){
        this.emailId=email;
        this.password=password;
    }

    @Override
    public void pay(double amount) {
        System.out.println(amount + " paid using Paypal.");
    }

}