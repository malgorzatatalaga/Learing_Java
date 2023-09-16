package learn.generics.wildcard;

import java.util.logging.Level;
import java.util.logging.Logger;

public class WildcardMain {
    private static final Logger logger = Logger.getLogger(WildcardMain.class.getName());

    public static void main(String[] args) {
        Wildcard<Integer> integerWildcard = new Wildcard<>(8, 9);
        Wildcard<Double> doubleWildcard = new Wildcard<>(5.4, 11.6);
        /*
        A bounded wildcard to loosen the restrictions on the variable and outline the group of types that can be used:
         */
        Wildcard<? extends Number> number = new Wildcard<>(10, 12.0);
        boolean isEqual = integerWildcard.equals(doubleWildcard);
        if (logger.isLoggable(Level.INFO)) {
            logger.info(String.valueOf(isEqual));
            logger.info(String.valueOf(number.performAddition()));
        }
    }
}
