package projects.io.scanner.formatter;

import projects.io.scanner.formatter.model.Car;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarCsvReader {

    public List<Car> readCars(File file) {
        List<Car> cars = new ArrayList<>();
        Scanner scanner = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(String.valueOf(file)))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                scanner = new Scanner(line);
                scanner.useDelimiter(",");
                String brand = scanner.next();
                String model = scanner.next();
                int cylinderCapacityCcm = scanner.nextInt();
                int performanceKwh = scanner.nextInt();
                double accelerationSec = scanner.nextDouble();
                cars.add(new Car(brand, model, cylinderCapacityCcm, performanceKwh, accelerationSec));
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cars;
    }
}
