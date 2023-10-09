public class Card implements PaymentStrategy {
    private String cardNumber;

    public Card(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Paid $" + amount + " using Card " + cardNumber);
    }
}