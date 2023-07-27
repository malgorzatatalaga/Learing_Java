package projects.classes;

public class HalvingCarousel extends DecrementingCarousel {

    static boolean isHalvingCarousel;
    public HalvingCarousel(int capacity) {
        super(capacity);
        isHalvingCarousel = true;
    }
}
