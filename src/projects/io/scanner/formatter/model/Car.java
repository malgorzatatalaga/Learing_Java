package projects.io.scanner.formatter.model;

public class Car {

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getCylinderCapacityCcm() {
        return cylinderCapacityCcm;
    }

    public int getPerformanceKwh() {
        return performanceKwh;
    }

    public double getAccelerationSec() {
        return accelerationSec;
    }

    private String brand;
    private String model;
    private int cylinderCapacityCcm;
    private int performanceKwh;
    private double accelerationSec;

    public Car() {
    }

    public Car(String brand, String model, int cylinderCapacityCcm, int performanceKwh, double accelerationSec) {
        this.brand = brand;
        this.model = model;
        this.cylinderCapacityCcm = cylinderCapacityCcm;
        this.performanceKwh = performanceKwh;
        this.accelerationSec = accelerationSec;
    }

    @Override
    public String toString() {
        return "Car{" +
                brand + ", " +
                model + ", " +
                cylinderCapacityCcm + ", " +
                performanceKwh + ", " +
                accelerationSec +
                '}';
    }
}
