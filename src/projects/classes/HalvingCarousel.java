package projects.classes;

public class HalvingCarousel extends DecrementingCarousel {

    public HalvingCarousel(int capacity) {
        super(capacity);
    }

    @Override
    public HalvingCarouselRun run() {
        if (!running) {
            running = true;
            return new HalvingCarouselRun();
        } else {
            return null;
        }
    }
}
