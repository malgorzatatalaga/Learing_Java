package projects.classes;

public class GraduallyDecreasingCarousel extends DecrementingCarousel {
    {
        i = 1;
    }
    static int i = 1;

    static int decrease() {
        i = i + 1;
        return i;
    }

    static boolean isGraduallyDecreasing;
    public GraduallyDecreasingCarousel(final int capacity) {
        super(capacity);
        isGraduallyDecreasing = true;
    }
}

