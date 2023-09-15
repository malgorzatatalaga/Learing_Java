package projects.classes.extended;

public class HalvingCarouselRun extends CarouselRun {

    {
        index = 0;
    }

    private int index;

    @Override
    public int next() {
        int beforeHalving;
        if (isFinished()) {
            return -1;
        } else {
            while (elementsOfTheCarousel[index %= elementsOfTheCarousel.length] <= 0) {
                index++;
            }
            beforeHalving = elementsOfTheCarousel[index];
            elementsOfTheCarousel[index++] /= 2;
        }
        return beforeHalving;
    }
}

