package projects.collections.lists.and.queues;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Predicate;

public class NewPostOfficeStorageImpl implements NewPostOfficeStorage {
    private final List<Box> parcels;

    public NewPostOfficeStorageImpl() {
        parcels = new LinkedList<>();
    }

    public NewPostOfficeStorageImpl(Collection<Box> boxes) {
        if (boxes == null) throw new NullPointerException();
        for (Box box : boxes) {
            if (box == null) throw new NullPointerException();
        }
        parcels = new LinkedList<>(boxes);
    }

    @Override
    public boolean acceptBox(Box box) {
        if (box == null) {
            throw new NullPointerException();
        } else {
            parcels.add(box);
            return true;
        }
    }

    @Override
    public boolean acceptAllBoxes(Collection<Box> boxes) {
        if (boxes == null) throw new NullPointerException();
        for (Box box : boxes) {
            if (box == null) throw new NullPointerException();
        }
        return parcels.addAll(boxes);
    }

    @Override
    public boolean carryOutBoxes(Collection<Box> boxes) {
        if (boxes == null) throw new NullPointerException();
        for (Box box : boxes) {
            if (box == null) throw new NullPointerException();
        }
        return parcels.removeAll(boxes);
    }

    @Override
    public List<Box> carryOutBoxes(Predicate<Box> predicate) {
        if (predicate == null) throw new NullPointerException();
        List<Box> removedBoxes = new LinkedList<>();
        Iterator<Box> iterator = parcels.iterator();

        while (iterator.hasNext()) {
            Box box = iterator.next();
            if (predicate.test(box)) {
                removedBoxes.add(box);
                iterator.remove(); // Remove the box from the storage
            }
        }

        return removedBoxes;
    }

    @Override
    public List<Box> getAllWeightLessThan(double weight) {
        if (weight <= 0.0) throw new IllegalArgumentException();
        Predicate<Box> weightPredicate = box -> box.getWeight() < weight;
        return searchBoxes(weightPredicate);
    }

    @Override
    public List<Box> getAllCostGreaterThan(BigDecimal cost) {
        if (cost.signum() == -1) throw new IllegalArgumentException();
        Predicate<Box> costPredicate = box -> box.getCost().compareTo(cost) > 0;
        return searchBoxes(costPredicate);
    }

    @Override
    public List<Box> getAllVolumeGreaterOrEqual(double volume) {
        if (volume < 0.0) throw new IllegalArgumentException();
        Predicate<Box> volumePredicate = box -> box.getVolume() >= volume;
        return searchBoxes(volumePredicate);
    }

    @Override
    public List<Box> searchBoxes(Predicate<Box> predicate) {
        if (predicate == null) throw new NullPointerException();
        List<Box> result = new ArrayList<>();
        for (Box box : parcels) {
            if (predicate.test(box)) {
                result.add(box);
            }
        }
        return result;
    }

    @Override
    public void updateOfficeNumber(Predicate<Box> predicate, int newOfficeNumber) {
        if (predicate == null) throw new NullPointerException();
        if (newOfficeNumber <= 0) throw new IllegalArgumentException();
        for (Box box : parcels) {
            if (predicate.test(box)) {
                box.setOfficeNumber(newOfficeNumber);
            }
        }
    }
}

