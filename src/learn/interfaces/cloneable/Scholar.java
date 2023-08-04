package learn.interfaces.cloneable;

import java.util.Date;

public class Scholar implements Cloneable {
    private Date yearSet;
    private int group;

    public Scholar(Date yearSet, int group) {
        this.yearSet = yearSet;
        this.group = group;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Scholar scholar = (Scholar) super.clone(); //shallow cloning to get a new object
        //clone the field yearSet and overwrite the copy in the field yearSet of the new object:
        scholar.yearSet = (Date) this.yearSet.clone(); //creating a copy of all reference fields
        return scholar;
    }

    @Override
    public String toString() {
        return "yearSet=" + yearSet +
                ", group=" + group;
    }
}
