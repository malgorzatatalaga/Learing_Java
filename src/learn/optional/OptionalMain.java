package learn.optional;

import java.util.Optional;

public class OptionalMain {
    public static void main(String[] args) {
        int[] ints = {1, 3, 5};
        IntService service = new IntService();
        double avg = service.average(ints);
        System.out.println(avg);
        Optional<Double> avgOpt = service.averageOpt(ints);
        avgOpt.ifPresent(System.out::println);
        /*
        The orElse() method returns the passed value if the Optional object contains no value, meaning if it is empty.
        Otherwise, the value contained in the object is returned.
         */
        System.out.println(avgOpt.orElse(Double.NaN));
    }
}
