package projects.collections.lists.and.queues;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public interface NewPostOfficeStorage {
    boolean acceptBox(Box box);

    boolean acceptAllBoxes(Collection<Box> boxes);

    boolean carryOutBoxes(Collection<Box> boxes);

    List<Box> carryOutBoxes(Predicate<Box> predicate);

    List<Box> getAllWeightLessThan(double weight);

    List<Box> getAllCostGreaterThan(BigDecimal cost);

    List<Box> getAllVolumeGreaterOrEqual(double volume);

    List<Box> searchBoxes(Predicate<Box> predicate);

    void updateOfficeNumber(Predicate<Box> predicate, int newOfficeNumber);
}

