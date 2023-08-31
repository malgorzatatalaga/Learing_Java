package projects.strings;

import java.util.Arrays;
import java.util.regex.Pattern;

public class StringUtil {
    public static int countEqualIgnoreCaseAndSpaces(String[] words, String sample) {
        int count = 0;
        if (sample == null || sample.isBlank())
            return 0;
        else {
            sample = sample.trim();
            for (String word : words) {
                word = word.trim();
                if (word.equalsIgnoreCase(sample)) {
                    count++;
                }
            }
            return count;
        }
    }

    public static String[] splitWords(String text) {
        if (text == null || text.isBlank() || text.matches("[!,;.:? ]+?"))
            return null;
        else {
            Pattern pattern = Pattern.compile("[ ,!;.:?]+");
            return pattern.split(text);
        }
    }

    public static String convertPath(String path, boolean toWin) {
        return path;
    }

    public static String joinWords(String[] words) {
        if (words == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < words.length - 1; i++) {
            if (words[i] == null) {
                return null;
            } else if (!words[i].isBlank()) {
                stringBuilder.append(words[i]).append(", ");
            }
        }
        stringBuilder.append(words[words.length - 1]).append("]");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println("Test 1: countEqualIgnoreCaseAndSpaces");
        String[] words = new String[]{" WordS    \t", "words", "w0rds", "WOR  DS",};
        String sample = "words   ";
        int countResult = countEqualIgnoreCaseAndSpaces(words, sample);
        System.out.println("Result: " + countResult);
        int expectedCount = 2;
        System.out.println("Must be: " + expectedCount);

        System.out.println("Test 2: splitWords");
        String text = "   ,, first, second!!!! third";
        String[] splitResult = splitWords(text);
        System.out.println("Result : " + Arrays.toString(splitResult));
        String[] expectedSplit = new String[]{"first", "second", "third"};
        System.out.println("Must be: " + Arrays.toString(expectedSplit));

        System.out.println("Test 4: joinWords");
        String[] toJoin = new String[]{"go", "with", "the", "", "FLOW"};
        String joinResult = joinWords(toJoin);
        System.out.println("Result: " + joinResult);
        String expectedJoin = "[go, with, the, FLOW]";
        System.out.println("Must be: " + expectedJoin);
    }
}
