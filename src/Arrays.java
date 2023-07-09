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
    }
}
