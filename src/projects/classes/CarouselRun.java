package projects.classes;

public class CarouselRun {
    private final int lastElementIndex = DecrementingCarousel.actual - 1;
    int[] numbers = DecrementingCarousel.numbers.clone();
    private int index;

    public int next() {
        int result;
        if (isFinished()) {
            return -1;
        } else if (HalvingCarousel.isHalvingCarousel) {
            result = halvingCarouselRun();
        } else {
            result = decrementingCarouselRun();
        }
        return result;
    }

    public int halvingCarouselRun() {
        int returnValue;
        if (index > lastElementIndex) {
            index = 0;
        }
        while (numbers[index] <= 0 && index <= lastElementIndex) {
            index++;
            if (index > lastElementIndex) {
                index = 0;
            }
        }
        returnValue = numbers[index];
        numbers[index++] /= 2;
        return returnValue;
    }

    public int decrementingCarouselRun() {
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

    public boolean isFinished() {
        for (int i : numbers) {
            if (i > 0) {
                return false;
            }
        }
        return true;
    }

}

