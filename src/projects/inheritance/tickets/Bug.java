package projects.inheritance.tickets;

public class Bug extends Ticket {
    private final UserStory userStory;
    public static Bug createBug(int id, String name, int estimate, UserStory userStory) {
        return userStory.isCompleted() || userStory == null ? new Bug(id, name, estimate, userStory) : null;
    }

    private Bug(int id, String name, int estimate, UserStory userStory) {
        super(id, name, estimate);
        this.userStory = userStory;
    }

    @Override
    public String toString() {
        return "[Bug " + getId() + "] " + userStory.getName() + ": " + getName();
    }
}
