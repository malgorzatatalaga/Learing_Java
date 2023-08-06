package projects.interfaces;

import java.util.ArrayList;
import java.util.List;

public class TaskCarousel {

    private final List<Task> tasks;
    private final int capacity;
    private int currentIndex;

    public TaskCarousel(int capacity) {
        this.tasks = new ArrayList<>(capacity);
        this.capacity = capacity;
    }

    public boolean addTask(Task task) {
        if (task != null && !task.isFinished() && tasks.size() < capacity) {
            tasks.add(task);
            return true;
        }
        return false;
    }

    public boolean execute() {
        if (!tasks.isEmpty()) {
            if (tasks.size() == 1) {
                Task task = tasks.get(0);
                task.execute();
                if (task.isFinished()) {
                    tasks.remove(0);
                }
            } else {
                Task task = tasks.get(currentIndex);
                task.execute();
                if (task.isFinished()) {
                    tasks.remove(currentIndex);
                    if (currentIndex >= tasks.size()) {
                        currentIndex = 0;
                    }
                } else {
                    currentIndex = (currentIndex + 1) % tasks.size();
                }
            }
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    public boolean isFull() {
        return tasks.size() >= capacity;
    }
}

