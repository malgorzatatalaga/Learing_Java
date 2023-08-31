package learn.exceptions;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class Numbers {
    public static void main(String[] args) {
        double value;
        NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
        try {
            value = (double) format.parse("27,06");
            System.out.println(value);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
