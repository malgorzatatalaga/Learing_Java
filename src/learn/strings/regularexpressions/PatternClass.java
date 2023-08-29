package learn.strings.regularexpressions;

import java.util.regex.Pattern;

public class PatternClass {
    public static void main(String[] args) {
        /*
        The method flags() returns the values of the parameter flags of a regular expression that were set
        when creating the regular expression (the default value is 0 if no values have been set).
         */
        Pattern pattern = Pattern.compile("java");
        System.out.println(pattern.flags());
        Pattern otherPattern = Pattern.compile("abc", Pattern.CASE_INSENSITIVE);
        System.out.println(otherPattern.flags());
        /*
        The method matches (String regex, CharSequence input) compiles the given regular expression
        (set using regex) and tries to compare the given input (parameter input) with it. It returns:
        - true–if the text matches the regular expression
        - false–if it doesn't
         */
        System.out.println(Pattern.matches("J.+a","Java"));
        System.out.println(Pattern.matches("J.+a","Java JavaScript"));
        /*
        The method split (CharSequence text, int limit) splits the given input sequence text
        into an array of strings String. The parameter limit controls the number of uses of the pattern and, thus,
        affects the length of the resulting array.
        If limit=0 – the pattern will be used as many times as possible, the array can have any length,
        and the trailing empty strings will be discarded.
         */
        String str1 = "One two,three!four;five six.seven";
        Pattern p1 = Pattern.compile("[ ,!;.]");
        String[] s1 = p1.split(str1);
        System.out.println("Source string  -> " + str1);
        for (String i : s1) {
            System.out.println("Lexeme: " + i);
        }
        /*
        If limit>0 – the pattern will be used maximum limit-1times, the array length will not exceed limit,
        and the last array entry will contain all input data except for the last matched delimiter.
         */
        String str2 = "One two,three!four;five six.seven";
        Pattern p2 = Pattern.compile("[ ,!;.]");
        String[] s2 = p2.split(str1, 2);
        System.out.println("Source string -> " + str2);
        for (String i : s2)
            System.out.println("Lexeme: " + i);
        }
        /*
        If limit<0 – the pattern will be used as many times as possible and the array can have any length.
         */

}
