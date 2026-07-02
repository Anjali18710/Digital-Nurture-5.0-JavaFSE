public class Logger {

    // The one and only instance — private so nobody can access it directly
    private static Logger instance;

    // Private constructor — prevents anyone from doing "new Logger()"
    private Logger() {
        System.out.println("Logger instance created.");
    }

    // The only way to get the Logger
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // A sample logging method
    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}