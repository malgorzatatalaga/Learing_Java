package learn.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratingCollections {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("fortran");
        collection.add("c#");
        collection.add("java");
        System.out.println( collection);
        /* ConcurrentModificationException
        for (String element :  collection) {
            System.out.println(element);
            collection.remove(element);
        }
         */
        Iterator<String> itr = collection.iterator();
        while (itr.hasNext()) {
            String current = itr.next();
            if (current.equals("c#")) {
                itr.remove();
            }
        }
        System.out.println( collection);
    }
}
