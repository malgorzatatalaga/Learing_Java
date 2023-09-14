package projects.enums;

public enum Direction {
    N(0), NE(45), E(90), SE(135), S(180), SW(225), W(270), NW(315);

    Direction(final int degrees) {
        this.degrees = degrees;
    }

    private final int degrees;

    public static Direction ofDegrees(int degrees) {
        if (degrees / 360 >= 1) {
            degrees = degrees - 360 * (degrees / 360);
        } else if (degrees < 0) {
            degrees = degrees + 360;
        }
        return switch (degrees) {
            case 0 -> Direction.N;
            case 45 -> Direction.NE;
            case 90 -> Direction.E;
            case 135 -> Direction.SE;
            case 180 -> Direction.S;
            case 225 -> Direction.SW;
            case 270 -> Direction.W;
            case 315 -> Direction.NW;
            default -> null;
        };
    }

    public static Direction closestToDegrees(int degrees) {
        degrees = ((degrees / 360) >= 1) ? (degrees - (360 * (degrees / 360))) : degrees;
        degrees = degrees < 0 ?  degrees + 360 : degrees;
        if (degrees >= 0 && degrees <= 22) {
            return Direction.N;
        } else if (degrees > 22 && degrees <= 67) {
            return Direction.NE;
        } else if (degrees > 67 && degrees <= 112) {
            return Direction.E;
        } else if (degrees > 112 && degrees <= 157) {
            return Direction.SE;
        } else if (degrees > 157 && degrees <= 202) {
            return Direction.S;
        } else if (degrees > 202 && degrees <= 247) {
            return Direction.SW;
        } else if (degrees > 247 && degrees <= 292) {
            return Direction.W;
        } else {
            return Direction.NW;
        }
    }

    public Direction opposite() {
        return switch (this.degrees) {
            case 0 -> Direction.S;
            case 45 -> Direction.SW;
            case 90 -> Direction.W;
            case 135 -> Direction.NW;
            case 180 -> Direction.N;
            case 225 -> Direction.NE;
            case 270 -> Direction.E;
            case 315 -> Direction.SE;
            default -> null;
        };
    }

    public int differenceDegreesTo(Direction direction) {
        if (Math.abs(this.degrees - direction.degrees) > 180) {
            return 360 - direction.degrees;
        } else {
            return Math.abs(this.degrees - direction.degrees);
        }
    }
}

