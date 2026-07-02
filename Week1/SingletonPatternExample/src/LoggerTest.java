public class LoggerTest {
    public static void main(String[] args) {

        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        Logger logger3 = Logger.getInstance();

        logger1.log("First message");
        logger2.log("Second message");

        // This should print true — both variables point to the same object
        System.out.println("Same instance? " + (logger1 == logger2));
        System.out.println("Same instance? " + (logger2 == logger3));
    }
}