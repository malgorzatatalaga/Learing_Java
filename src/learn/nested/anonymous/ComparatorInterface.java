package learn.nested.anonymous;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorInterface {
    /**
     * Comparator interface, it is convenient to use an anonymous class because:
     * - Only one method is implemented.
     * - Only one object of this type is required.
     * - The implementation code will be placed close to where it is used.
     */
    public static void main(String[] args) {
        String[] arr = {"java", "scala", "fortran", "ada", "modula"};
        Arrays.sort(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                String str1 = (String) o1;
                String str2 = (String) o2;
                return str2.compareTo(str1);
            }
        });
        System.out.println(Arrays.toString(arr));
    }
}
