public class Mobile implements PaymentStrategy {
    private String phoneNumber;

    public Mobile(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Paid $" + amount + " with Mobile Payments " + phoneNumber);
    }
}