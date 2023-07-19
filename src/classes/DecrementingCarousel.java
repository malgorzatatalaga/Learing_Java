package classes;

import java.util.ArrayList;
import java.util.List;

public class DecrementingCarousel {
    private boolean running;

    private int numberOfElements = 0;
    private int index = 0;

    static List<Integer> carouselNumbers = new ArrayList<>();
    private final int capacity;

    public DecrementingCarousel(int capacity) {
        this.capacity = capacity;
    }

    public boolean addElement(int element){
        if ((numberOfElements < capacity) && (element > 0) && !running) {
            numberOfElements++;
            carouselNumbers.add(element);
            index++;
            return true;
        } else {
            return false;
        }
    }

    public CarouselRun run(){
        if (running) {
            return null;
        } else {
            running = true;
            return new CarouselRun();
        }
    }
}
