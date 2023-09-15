package projects.classes.extended;

public class GraduallyDecreasingCarouselRun extends CarouselRun {

    {
        index = 0;
    }

    int decrement = 1;
    int index;

    @Override
    public int next() {
        int beforeDecreasing;
        if (isFinished())
            return -1;
        else {
            if (index == elementsOfTheCarousel.length) {
                decrement++;
            }
            while (elementsOfTheCarousel[index %= elementsOfTheCarousel.length] <= 0 && !isFinished()) {
                index++;
                if (index == elementsOfTheCarousel.length) {
                    decrement++;
                }
            }
            beforeDecreasing = elementsOfTheCarousel[index];
            elementsOfTheCarousel[index++] -= decrement;
        }
        return beforeDecreasing;
    }

}

