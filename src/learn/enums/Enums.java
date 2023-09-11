package learn.enums;

import java.util.Arrays;

public class Enums {
    /**
     * By declaring an enum, you are implicitly describing a class:
     * final class Season {
     *     public static final int WINTER = 0;
     *     public static final int SPRING = 1;
     *     public static final int SUMMER = 2;
     *     public static final int FALL = 3;
     * }
     */
    public enum Season {
        WINTER, SPRING, SUMMER, FALL;
        public String toString(){
            return "Season: " + this.name();
        }
    }
    public static void main(String[] args) {
        //name() - Returns the name of the current constant exactly as declared in its enum declaration.
        System.out.println(Season.WINTER.name());
        //ordinal() - Returns the index (position) of the current constant.
        System.out.println(Season.WINTER.ordinal());
        //values() - Returns an array of all enum values in the order they are declared.
        Season[] seasons = Season.values();
        System.out.println(Arrays.toString(seasons));
        //valueOf() - Returns the enum constant that corresponds to the specified string.
        System.out.println(Season.valueOf("WINTER"));
        //compareTo() - Constant values of the enum can only be compared within the same enum type.
        System.out.println(Season.SPRING.compareTo(Season.WINTER));
        System.out.println(Season.SPRING.compareTo(Season.SPRING));
        System.out.println(Season.SPRING.compareTo(Season.SUMMER));
        System.out.println(Season.WINTER.compareTo(Season.SUMMER));
        //equals() - Method responsible for comparing enum values and does so based on references.
        System.out.println(Season.WINTER.equals(Season.WINTER));
        System.out.println(Season.WINTER.equals(Season.SUMMER));
        Season season = Season.WINTER;
        System.out.println(season == Season.WINTER);
        System.out.println(season == Season.SUMMER);
        //hashCode()
        int hashOfWinter = Season.WINTER.hashCode();
        int hashOfSummer = Season.SUMMER.hashCode();
        System.out.println(hashOfWinter);
        System.out.println(hashOfSummer);
        //toString()
        System.out.println(Season.SPRING);
        System.out.println(Season.SUMMER);
        System.out.println(Season.WINTER);
        System.out.println(Season.FALL);
    }

    public final boolean equals(Object other) {
        return this == other;
    }
}
