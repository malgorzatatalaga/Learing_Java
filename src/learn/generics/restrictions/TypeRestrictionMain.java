package learn.generics.restrictions;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TypeRestrictionMain {
    public static final Logger logger = Logger.getLogger(TypeRestrictionMain.class.getName());
    public static void main(String[] args) {
        double  xDouble = Math.random() * 100;
        double  yDouble = Math.random() * 100;
        TypeRestriction<Double> doubleTypeRestriction = new TypeRestriction<>(xDouble, yDouble);
        double resultDouble = doubleTypeRestriction.performCalculation();
        if (logger.isLoggable(Level.INFO)) {
            logger.info( xDouble + " / " + yDouble + " = " + resultDouble);
        }
        short   xShort = (short)(Math.random() * 100);
        short   yShort = (short)(Math.random() * 100);
        TypeRestriction<Short> shortTypeRestriction = new TypeRestriction<>(xShort, yShort);
        double resultShort = shortTypeRestriction.performCalculation();
        if (logger.isLoggable(Level.INFO)) {
            logger.info( xShort + " / " + yShort + " = " + resultShort);
        }
        /*
        TypeRestriction<Character> characterTypeRestriction = new TypeRestriction<Character>('8', '9');
        Compilation error:
        Type parameter 'java.lang.Character' is not within its bound; should extend 'java.lang.Number'
         */
    }
}
