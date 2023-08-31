package projects.strings;

import java.util.Arrays;
import java.util.regex.Pattern;

public class StringUtil {
    public static int countEqualIgnoreCaseAndSpaces(String[] words, String sample) {
        int count = 0;
        if (sample == null || words == null || sample.isBlank())
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
            text = text.trim();
            Pattern pattern = Pattern.compile("[!,;.:? ]+");
            String[] words = pattern.split(text);
            if (words.length > 0 && words[0].isBlank()) {
                words = Arrays.copyOfRange(words, 1, words.length);
            }
            return words;
        }
    }

    public static String convertPath(String path, boolean toWin) {
        if (path == null || path.isBlank()) {
            return null;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public static String joinWords(String[] words) {
        int caseInt;
        String result = null;
        if (words == null || words.length == 0) {
            return null;
        }
        int counter = 0;
        for (String s: words) {
            if (!s.isBlank()) {
                counter++;
            }
        }
        if (counter == 0) {
            return null;
        }
        if (words[words.length-1].isBlank()) {
            caseInt = 0;
        } else {
            caseInt = 1;
        }

        switch (caseInt) {
            case 0 -> result = case0(words);
            case 1 -> result = case1(words);
        }
        return result;
    }

    private static String case0(String[] words) {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < words.length - 2; i++) {
            if (words[i] == null) {
                return null;
            } else if (!words[i].isBlank()) {
                stringBuilder.append(words[i]).append(", ");
            }
        }
        stringBuilder.append(words[words.length-2]).append("]");
        return stringBuilder.toString();
    }

    private static String case1(String[] words) {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < words.length - 1; i++) {
            if (words[i] == null) {
                return null;
            } else if (!words[i].isBlank()) {
                stringBuilder.append(words[i]).append(", ");
            }
        }
        stringBuilder.append(words[words.length-1]).append("]");
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

//        System.out.println("Test 3: convertPath");
//        String unixPath = "/some/unix/path";
//        String convertResult = convertPath(unixPath, true);
//        System.out.println("Result: " + convertResult);
//        String expectedWinPath = "C:\\some\\unix\\path";
//        System.out.println("Must be: " + expectedWinPath);

        System.out.println("Test 4: joinWords");
        String[] toJoin = new String[]{"go", "with", "the", "", "FLOW"};
        String joinResult = joinWords(toJoin);
        System.out.println("Result: " + joinResult);
        String expectedJoin = "[go, with, the, FLOW]";
        System.out.println("Must be: " + expectedJoin);
    }
}