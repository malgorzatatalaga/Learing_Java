package projects.generics.house;

import projects.generics.residents.cats.Cat;
import projects.generics.residents.cats.Kitten;
import projects.generics.residents.dogs.Dog;
import projects.generics.residents.dogs.Puppy;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HouseMain {
    private static final Logger logger = Logger.getLogger(HouseMain.class.getName());
    public static void main(String[] args) {
        Dog milan = new Dog("Milan");
        Puppy marcy = new Puppy("Marcy");
        Cat misiu = new Cat("Misiu");
        Kitten skarpeta = new Kitten("Skarpeta");

        House<Dog> dogHouse = new House<>();
        dogHouse.enter(milan);
        dogHouse.enter(marcy);
        if (logger.isLoggable(Level.INFO)) {
            logger.info(dogHouse.toString());
        }

        House<Cat> catHouse = new House<>();
        catHouse.enter(misiu);
        catHouse.enter(skarpeta);
        if (logger.isLoggable(Level.INFO)) {
            logger.info(catHouse.toString());
        }
    }
}
