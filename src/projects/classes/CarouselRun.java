package projects.classes;

public class CarouselRun {

    final int[] elementsOfTheCarousel = DecrementingCarousel.elementsOfTheCarousel.clone();
    private int index;

    public int next() {
        if (isFinished()) {
            return -1;
        } else {
            while (elementsOfTheCarousel[index %= elementsOfTheCarousel.length] <= 0) {
                index++;
            }
        }
        return elementsOfTheCarousel[index++]--;
    }

    public boolean isFinished() {
        for (int element: elementsOfTheCarousel) {
            if (element > 0) return false;
        }
        return true;
    }
}
