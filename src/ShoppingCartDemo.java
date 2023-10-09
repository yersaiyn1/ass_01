import java.util.List;
import java.util.Scanner;

public class ShoppingCartDemo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        Scanner scanner = new Scanner(System.in);

        while (true) { // gaga
            System.out.println(" ");
            System.out.println("Choose an option:");
            System.out.println("1. Add Product");
            System.out.println("2. View Cart");
            System.out.println("3. Choose Payment Strategy");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("Enter product name:");
                    String productName = scanner.next();
                    System.out.println("Enter product price:");
                    double productPrice = scanner.nextDouble();
                    System.out.println("Enter product quantity:");
                    int productQuantity = scanner.nextInt();
                    Product product = new Product(productName, productPrice, productQuantity);
                    cart.addProduct(product);
                }
                case 2 -> {
                    List<Product> items = cart.getItems();
                    System.out.println("Cart Contents:");
                    for (Product item : items) {
                        System.out.println(item.getName() + " - $" + item.getTotalPrice());
                    }
                }
                case 3 -> {
                    System.out.println("Choose a payment strategy:");
                    System.out.println("1. Card");
                    System.out.println("2. Mobile");
                    int paymentChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (paymentChoice == 1) {
                        PaymentStrategy creditCardPayment = new Card("1234-5678-9012-xxxx");
                        cart.setPaymentProcessor(paymentProcessor);
                        paymentProcessor.setPaymentStrategy(creditCardPayment);
                    } else if (paymentChoice == 2) {
                        PaymentStrategy payPalPayment = new Mobile("+7-777-666-xx-xx");
                        cart.setPaymentProcessor(paymentProcessor);
                        paymentProcessor.setPaymentStrategy(payPalPayment);
                    } else {
                        System.out.println("Invalid payment choice.");
                    }
                }
                case 4 -> cart.checkout();
                case 5 -> {
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
