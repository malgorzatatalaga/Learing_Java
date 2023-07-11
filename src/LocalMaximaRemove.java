import java.util.Arrays;

public class LocalMaximaRemove {
    /*
    The correct implementation should receive an array of int values and return a copy
    of a given array with all local maxima removed in it. The original array must not be changed.
    Local maximum is an element that is bigger that any of its neighbour elements.
    You should remove elements that are local maxima in the original array.
     */
    public static int[] removeLocalMaxima(int[] array) {
        int[] result = new int[array.length];
        int j = 0;

        for (int i = 0; i < array.length; i++) {
            if ((i > 0 && array[i] <= array[i - 1]) || (i != array.length - 1 && array[i] <= array[i + 1])) {
                result[j] = array[i];
                j++;
            }
        }
        return Arrays.copyOf(result, j);
    }
}
