package inheritance.tickets;

public class Ticket {

    {
        completed = false;
    }
    private final int id;
    private final String name;
    boolean completed;
    private final int estimate;

    public Ticket(int id, String name, int estimate) {
        super();
        this.id = id;
        this.name = name;
        this.estimate = estimate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void complete() {
        this.completed = true;
    }

    public int getEstimate() {
        return estimate;
    }
}

