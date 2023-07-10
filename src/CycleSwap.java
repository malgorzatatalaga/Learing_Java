public class CycleSwap {

    static void cycleSwap(int[] array) {
        if (array.length > 0) {
            int lastElem = array[array.length - 1];
            System.arraycopy(array, 0, array, 1, array.length - 1);
            array[0] = lastElem;
        }
    }

    static void cycleSwap(int[] array, int shift) {
        while (shift > 0){
            if (array.length == 0) break;
            int lastElem = array[array.length-1];
            System.arraycopy(array, 0, array, 1, array.length -1);
            array[0] = lastElem;
            shift--;
        }
    }

}
