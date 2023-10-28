package projects.collections.iteration;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

class NewPostOffice {
    private static final int COST_KILOGRAM = 5;
    private static final int COST_CUBIC_METER = 100;
    private static final double COEFFICIENT = 0.5;
    private final Collection<Box> listBox;

    public NewPostOffice() {
        listBox = new ArrayList<>();
    }

    static BigDecimal calculateCostOfBox(double weight, double volume, int value) {
        BigDecimal costWeight = BigDecimal.valueOf(weight)
                .multiply(BigDecimal.valueOf(COST_KILOGRAM), MathContext.DECIMAL64);
        BigDecimal costVolume = BigDecimal.valueOf(volume)
                .multiply(BigDecimal.valueOf(COST_CUBIC_METER), MathContext.DECIMAL64);
        return costVolume.add(costWeight)
                .add(BigDecimal.valueOf(COEFFICIENT * value), MathContext.DECIMAL64);
    }

    public Collection<Box> getListBox() {
        return (Collection<Box>) ((ArrayList<Box>) listBox).clone();
    }

    public boolean addBox(String sender, String recipient, double weight, double volume, int value) {
        if (sender == null || recipient == null) throw new IllegalArgumentException();
        if (sender.isBlank() || recipient.isBlank()) throw new IllegalArgumentException();
        if (weight < 0.5 || weight > 20.0 || volume <= 0 || volume > 0.25 || value <= 0) {
            throw new IllegalArgumentException();
        }
        Box box = new Box(sender, recipient, weight, volume);
        box.setCost(calculateCostOfBox(weight, volume, value));
        listBox.add(box);
        return true;
    }

    public Collection<Box> deliveryBoxToRecipient(String recipient) {
        Collection<Box> delivery = new ArrayList<>();
        Iterator<Box> iterator = listBox.iterator();
        while (iterator.hasNext()) {
            Box currentBox = iterator.next();
            if (currentBox.getRecipient().equals(recipient)) {
                delivery.add(currentBox);
                iterator.remove();
            }
        }
        return delivery;
    }

    public void declineCostOfBox(double percent) {
        for (Box currentBox : listBox) {
            BigDecimal currentBoxCost = currentBox.getCost();
            BigDecimal percentDecimal = BigDecimal.valueOf(percent / 100);
            BigDecimal newCost = currentBoxCost.subtract(currentBoxCost.multiply(percentDecimal));
            MathContext mathContext = new MathContext(16, RoundingMode.HALF_UP);
            newCost = newCost.round(mathContext);
            currentBox.setCost(newCost);
        }
    }

}

