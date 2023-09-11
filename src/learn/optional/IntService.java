package learn.optional;

import java.util.Optional;

public class IntService {
    public double average(int[] ints) {
        double sum = 0;
        for (int element : ints) {
            sum += element;
        }
        return sum / ints.length;
    }
    public Optional<Double> averageOpt(int[] ints) {
        Optional<Double> result;
        if (ints != null && ints.length != 0) {
            double avg = average(ints);
            result = Optional.of(avg);
            /*
            Encapsulates a non-null value: if the value is null, then the following exception will be thrown:
            NullPointerException.
            */
        } else {
            result = Optional.empty(); //Encapsulates an empty object.
        }
        return result;
    }
}
