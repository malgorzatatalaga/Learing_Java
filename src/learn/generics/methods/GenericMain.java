package learn.generics.methods;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GenericMain {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(GenericMain.class.getName());
        byte b = GenericMethod.asByte(33.05);
        if (logger.isLoggable(Level.INFO)) {
            logger.info(String.valueOf(b));
        }
    }
}
