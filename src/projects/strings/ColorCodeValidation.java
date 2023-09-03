package projects.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorCodeValidation {
    public static boolean validateColorCode(String color) {
        if (color == null) {
            return false;
        }
        Pattern pattern = Pattern.compile("^(#([A-Fa-f0-9]{3}|[A-Fa-f0-9]{6}|[A-Fa-f0-9]{8}))$");
        Matcher matcher = pattern.matcher(color);
        return matcher.matches();
    }
}
