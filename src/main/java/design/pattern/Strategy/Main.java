package design.pattern.Strategy;

public class Main {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // Use Credit Card payment
        context.setPaymentStrategy(new CreditCardPayment("1234-5678-9876"));
        context.pay(100);

        // Use PayPal payment
        context.setPaymentStrategy(new PayPalPayment("user@example.com"));
        context.pay(200);
    }
}
