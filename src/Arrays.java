public class Arrays {
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
        int[][] array2D = { { 1, 2, 3, 4, 5 },
                            { 5, 4, 3, 2, 1 },
                            { 0, 2, 0, 4, 0 } };
        int sum = 0;

        for (int[]row : array2D) {
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

        int[][] arr = new int [4][];
        arr[0] = new int [] { 1, 3, 5, 7, 9 };
        arr[1] = new int [] { 2, 4, 6, 8 };
        arr[3] = new int [] { 77, 88, 99 };

        for (int[] row : arr) {
            if (row != null) {
                for (int element : row) {
                    System.out.print(element + " ");
                }
            } else {
                System.out.print(row);
            }
            System.out.println();
        }

    }
}
