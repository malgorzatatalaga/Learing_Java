package projects.inheritance.tickets;

public class UserStory extends Ticket {

    private final UserStory[] dependencies;

    public UserStory(int id, String name, int estimate, UserStory... dependsOn) {
        super(id, name, estimate);
        dependencies = dependsOn;
    }

    @Override
    public void complete() {
        if (dependencies.length == 0) {
            completed = true;
        } else {
            for (UserStory dependency :  dependencies) {
                if (!dependency.isCompleted()) {
                    completed = false;
                    break;
                }
                super.complete();
            }
        }
    }
    public UserStory[] getDependencies() {
        return dependencies.clone();
    }

    @Override
    public String toString() {
        return "[US " + this.getId() + "] " + this.getName();
    }
}

