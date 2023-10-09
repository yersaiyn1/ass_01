import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> items = new ArrayList<>();
    private PaymentProcessor paymentProcessor;

    public void addProduct(Product product) {
        items.add(product);
    }

    public double calculateTotalPrice() {
        double totalPrice = 0.0;
        for (Product product : items) {
            totalPrice += product.getTotalPrice();
        }
        return totalPrice;
    }

    public void checkout() {
        if (paymentProcessor != null) {
            double totalAmount = calculateTotalPrice();
            paymentProcessor.processPayment(totalAmount);
        } else {
            System.out.println("Payment strategy is not set. Unable to complete checkout.");
        }
    }

    public List<Product> getItems() {
        return items;
    }

    public void setPaymentProcessor(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }
}