package projects.classes.wrapper;

@SuppressWarnings("unused")
public class Battleship8x8 {
    private final long ships;
    private long shots = 0L;

    public Battleship8x8(final long ships) {
        this.ships = ships;
    }

    public boolean shoot(String shot) {
        long newShot = 0b10000000_00000000_00000000_00000000_00000000_00000000_00000000_00000000L;
        switch (shot.charAt(0)) {
            case 'A': break;
            case 'B': {newShot >>>= 1; break;}
            case 'C': {newShot >>>= 2; break;}
            case 'D': {newShot >>>= 3; break;}
            case 'E': {newShot >>>= 4; break;}
            case 'F': {newShot >>>= 5; break;}
            case 'G': {newShot >>>= 6; break;}
            case 'H': {newShot >>>= 7; break;}
            default:
                throw new IllegalStateException("Unexpected value: " + shot.charAt(0));
        }
        newShot >>>= (8 * (shot.charAt(1) - 1));
        shots |= newShot;
        return ships == (ships | newShot);
    }

    public String state() {
        String result;
        StringBuilder binaryShips = new StringBuilder(Long.toBinaryString(ships));
        StringBuilder binaryShots = new StringBuilder(Long.toBinaryString(shots));
        adjustLength(binaryShips);
        adjustLength(binaryShots);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < binaryShots.length(); i++) {
            if (i%8 == 0)
                stringBuilder.append("\n");
            if (binaryShips.charAt(i) == '0' && binaryShots.charAt(i) == '0')
                stringBuilder.append(".");
            if (binaryShips.charAt(i) == '0' && binaryShots.charAt(i) == '1')
                stringBuilder.append("×");
            if (binaryShips.charAt(i) == '1' && binaryShots.charAt(i) == '0')
                stringBuilder.append("☐");
            if (binaryShips.charAt(i) == '1' && binaryShots.charAt(i) == '1')
                stringBuilder.append("☒");
        }
        result = stringBuilder.toString();
        return result;
    }

    public static void adjustLength(StringBuilder stringBuilder) {
        while (stringBuilder.length() < 64) {
            stringBuilder.insert(0, "0");
        }
    }
}