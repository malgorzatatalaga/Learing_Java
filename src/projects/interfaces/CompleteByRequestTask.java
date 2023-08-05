package projects.interfaces;

public class CompleteByRequestTask implements Task {

    private boolean finished;
    private boolean completed;

    public CompleteByRequestTask() {
    }

    @Override
    public void execute() {
        if (completed) {
            finished = true;
        }
    }

    @Override
    public boolean isFinished() {
        return finished;
    }

    public void complete() {
        completed = true;
    }
}

