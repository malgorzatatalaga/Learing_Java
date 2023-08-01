package projects.inheritance;

import projects.inheritance.tickets.Bug;
import projects.inheritance.tickets.Ticket;
import projects.inheritance.tickets.UserStory;

public class Sprint {
    private final int CAPACITY;
    private final int TICKETSLIMIT;
    private int totalCapacity;
    private int numberOfTickets;
    private final Ticket[] allTickets;
    private Ticket[] tickets;
    private int index;

    public Sprint(int capacity, int ticketsLimit) {
        this.CAPACITY = capacity;
        this.TICKETSLIMIT = ticketsLimit;
        allTickets = new Ticket[ticketsLimit];
    }

    public boolean addUserStory(UserStory userStory) {
        if (userStory == null) {
            return false;
        }
        if (!userStory.isCompleted()) {
            int dependencyCapacity = getDependenciesCapacity(userStory);
            int newCapacity = userStory.getEstimate() + totalCapacity + dependencyCapacity;
            if (newCapacity <= CAPACITY && numberOfTickets < TICKETSLIMIT) {
                add(userStory);
                return true;
            }
        }
        return false;
    }

    public boolean addBug(Bug bugReport) {
        if (bugReport == null || bugReport.isCompleted()) {
            return false;
        }
        int newCapacity = bugReport.getEstimate() + totalCapacity;
        if (totalCapacity >= CAPACITY || newCapacity >= CAPACITY || numberOfTickets >= TICKETSLIMIT) {
            return false;
        } else {
            add(bugReport);
            return true;
        }
    }

    private void add(Ticket ticket) {
        numberOfTickets++;
        totalCapacity += ticket.getEstimate();
        allTickets[index++] = ticket;
        tickets = new Ticket[numberOfTickets];
        System.arraycopy(allTickets, 0, tickets, 0, numberOfTickets);
    }

    public Ticket[] getTickets() {
        return tickets.clone();
    }

    public int getTotalEstimate() {
        return totalCapacity;
    }

    public int getDependenciesCapacity(UserStory userStory) {
        int dependencyCapacity = 0;
        for (UserStory dependency : userStory.getDependencies()) {
            dependencyCapacity += dependency.getEstimate();
        }
        return dependencyCapacity;
    }

}

