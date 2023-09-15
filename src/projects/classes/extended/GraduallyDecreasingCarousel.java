package projects.classes.extended;

public class GraduallyDecreasingCarousel extends DecrementingCarousel {

    public GraduallyDecreasingCarousel(int capacity) {
        super(capacity);
    }

    @Override
    public GraduallyDecreasingCarouselRun run() {
        if (!running) {
            running = true;
            return new GraduallyDecreasingCarouselRun();
        } else {
            return null;
        }
    }
}
