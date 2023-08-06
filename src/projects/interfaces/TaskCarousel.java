package projects.interfaces;

import java.util.ArrayList;
import java.util.List;

public class TaskCarousel {

    {
        i = 0;
    }
    private final List<Task> tasks;
    private final int capacity;
    int i;

    public TaskCarousel(int capacity) {
        this.tasks = new ArrayList<>(capacity);
        this.capacity = capacity;
    }

    public boolean addTask(Task task) {
        if (tasks.size() < capacity && !task.isFinished()) {
            tasks.add(task);
            return true;
        }
        return false;
    }

    public boolean execute() {
        if (!tasks.isEmpty()) {
            int index = i % tasks.size();
            Task task = tasks.get(index);
            task.execute();
            if (task.isFinished()) {
                tasks.remove(index);
            }
            i++;
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

