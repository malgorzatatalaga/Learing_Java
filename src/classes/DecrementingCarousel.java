package classes;

public class DecrementingCarousel {
    static int actual;
    static int[] numbers;
    private final int capacity;
    private int index;
    private boolean running;

    {
        index = 0;
        running = false;
        actual = 0;
    }

    public DecrementingCarousel(int capacity) {
        this.capacity = capacity;
        numbers = new int[capacity];
    }

    public boolean addElement(int element) {
        if (!running && element > 0 && (actual < capacity)) {
            numbers[index++] = element;
            actual++;
            return true;
        } else {
            return false;
        }
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
