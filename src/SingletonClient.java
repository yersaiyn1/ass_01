public class SingletonClient {
    public static void main(String[] args) {

        Runnable task = () -> {
            Singleton singleton = Singleton.getInstance();
            System.out.println("Singleton instance: " + singleton.hashCode());
            singleton.functionality();
        };

        Thread thread1 = new Thread(task);

        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

    }
}
