public class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void functionality() {
        System.out.println("method within the Singleton class to demonstrate its functionality");
    }
}
