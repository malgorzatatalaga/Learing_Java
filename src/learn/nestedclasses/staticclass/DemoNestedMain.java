package learn.nestedclasses.staticclass;

public class DemoNestedMain {
    public static void main(String[] args) {
        double[] array = new double[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = 100 * Math.random();
        }
        ArrayOperation.Pair pair = ArrayOperation.searchMinMax(array);
        System.out.println("min = " + pair.getMin());
        System.out.println("max = " + pair.getMax());
    }
}
