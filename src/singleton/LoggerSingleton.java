package Task1.singleton;

import java.util.logging.*;

public class LoggerSingleton {
    private static Logger logger;

    private LoggerSingleton() {}

    public static Logger getInstance() {
        if (logger == null) {
            logger = Logger.getLogger(LoggerSingleton.class.getName());
            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setLevel(Level.ALL);
            logger.addHandler(consoleHandler);
            logger.setLevel(Level.ALL);
            logger.setUseParentHandlers(false);
        }
        return logger;
    }
}