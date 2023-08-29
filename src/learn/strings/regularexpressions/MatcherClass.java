package learn.strings.regularexpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherClass {
    public static void main(String[] args) {
        String text = "This is my second java 45 project.\n" +
                "It is wonderful to learn polysemantics and arrays.\n" +
                "The weather is cold like it should be in winter, but we are all looking forward to spring.";
        Pattern p = Pattern.compile("\\b[\\w]{2}\\b");
        //creating a pattern search in the string text:
        Matcher m = p.matcher(text);
        //find()
        while (m.find()) {
            int start = m.start();
            System.out.println(start);
            int end = m.end();
            System.out.println("Found matches " + text.substring(start, end) + " from " + start + " to " + (end - 1) + " positions");
        }
        /*
        matches()
        The method matches() works as follows: the entire text is compared with the pattern.
        If it matches the pattern, the method returns the boolean true.
         */
        Pattern pattern = Pattern.compile("\\w*");
        Matcher matcher = pattern.matcher("Thanks!");
        System.out.println(matcher.matches());
        /*
        lookingAt()
        The method lookingAt() compares only the given text with the pattern.
        Unlike the method matches(), the entire text does not need to match the pattern.
        The method returns the boolean true, if at least some part of the source sequence
        matches the pattern.
         */
        Pattern pattern1 = Pattern.compile("\\w*");
        Matcher matcher1 = pattern1.matcher("Thanks!");
        System.out.println(matcher1.lookingAt());
        /*
        replaceFirst()
        The method replaceFirst(String replacement) works as follows: in the input sequence,
        the first subsequence matching the pattern is replaced with the parameter replacement.
         */
        System.out.println("Before:\n" + text);
        Pattern pattern2 = Pattern.compile("\\b\\w{2}\\b");
        Matcher matcher2 = pattern2.matcher(text);
        text = matcher2.replaceFirst("lab2");
        System.out.println("\nAfter:\n" + text);
    }
}
