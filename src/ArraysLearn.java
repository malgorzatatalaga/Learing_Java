import java.util.Arrays;

public class ArraysLearn {
    public static void main(String[] args) {
        int[] array = {10, 11, 12, 13};
        int[] hold = {14, 15, 16, 17, 18, 19, 20};

        //Copying arrays
        System.arraycopy(array, 0, hold, 0, array.length);
        System.out.println(java.util.Arrays.toString(hold));

        //Changing the length of an array
        int[] numbers = new int[7];
        numbers = new int[42]; // redeclaration

        /*Processing a Two-Dimensional Array
        Find the sum of the elements of a two-dimensional array.
         */
        int[][] array2D = {{1, 2, 3, 4, 5},
                {5, 4, 3, 2, 1},
                {0, 2, 0, 4, 0}};
        int sum = 0;

        for (int[] row : array2D) {
            for (int element : row) {
                sum += element;
            }
        }

        for (int[] row : array2D) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
        System.out.println("sum = " + sum);

        //Jagged Multidimensional Arrays (a set of arrays of different lengths)
        int[][] arr = new int[4][];
        arr[0] = new int[]{1, 3, 5, 7, 9};
        arr[1] = new int[]{2, 4, 6, 8};
        arr[3] = new int[]{77, 88, 99};
        System.out.println(Arrays.deepToString(arr));

    }
    public static boolean[] getSumCheckArray(int[] array) {
        /*
        The correct implementation should receive an array of int values and return an array of booleans
        where each element is a result of a check if a corresponding element is a sum
        of two previous elements in given array.
         */
        boolean[] booleans = new boolean[array.length];
        booleans[0] = false;
        booleans[1] = false;
        for (int i = 2; i < array.length; i++) {
            if (array[i - 2] + array[i - 1] == array[i]) {
                booleans[i] = true;
            } else {
                booleans[i] = false;
            }
        }
        return booleans;
    }
}
