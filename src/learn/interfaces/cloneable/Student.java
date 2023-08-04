package learn.interfaces.cloneable;

import java.util.Date;

public class Student implements Cloneable {
    private Date yearSet;
    private int group;
    public Student(Date year, int group) {
        this.yearSet = year;
        this.group = group;
    }
    public String toString() {
        return "year = " + yearSet + ", group = " + group;
    }
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
