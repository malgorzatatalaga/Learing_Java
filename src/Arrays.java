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

    }
}
