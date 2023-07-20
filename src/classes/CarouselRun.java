package classes;

public class CarouselRun {
    private final int lastElementIndex = DecrementingCarousel.actual - 1;
    int[] numbers = DecrementingCarousel.numbers.clone();
    private int index;

    public int next() {
        if (isFinished()) {
            return -1;
        } else {
            if (index > lastElementIndex) {
                index = 0;
            }
            while (numbers[index] <= 0 && index <= lastElementIndex) {
                index++;
                if (index > lastElementIndex) {
                    index = 0;
                }
            }
            return numbers[index++]--;
        }
    }

    public boolean isFinished() {
        for (int i : numbers) {
            if (i > 0) {
                return false;
            }
        }
        return true;
    }

}

