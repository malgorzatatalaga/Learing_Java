package projects.io.scanner.formatter;

import projects.io.scanner.formatter.model.Car;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

public class FormattedCarPrinter {

    public void print(List<Car> cars) {
        List<String> carsList = new ArrayList<>();
        for (Car car : cars) {
            Formatter formatter = new Formatter();
            formatter.format("%10s %10s %5d ccm %3d kw %5.2f sec", car.getBrand(), car.getModel(),
                    car.getCylinderCapacityCcm(), car.getPerformanceKwh(), car.getAccelerationSec());
            carsList.add(formatter.toString());
            formatter.close();
        }
        for (String s: carsList) {
            System.out.println(s);
        }
    }
}
