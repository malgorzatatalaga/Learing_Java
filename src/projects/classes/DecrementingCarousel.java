package projects.classes;

public class DecrementingCarousel {

    {
        running = false;
        currentNumberOfElements = 0;
    }

    private final int capacity;
    private int currentNumberOfElements;
    static int[] elementsOfTheCarousel;
    boolean running;


    public DecrementingCarousel(int capacity) {
        this.capacity = capacity;
        elementsOfTheCarousel = new int[capacity];
    }

    public boolean addElement(int element) {
        if (currentNumberOfElements < capacity && element > 0 && !running) {
            elementsOfTheCarousel[currentNumberOfElements++] = element;
            return true;
        }
        return false;
    }

    public CarouselRun run() {
        if (!running) {
            running = true;
            return new CarouselRun();
        } else {
            return null;
        }
    }
}
