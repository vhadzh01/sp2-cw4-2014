package sp2.cw4.ship;

public class Submarine extends Ship {

    public Submarine() {
        super.length = 1;
    }

    @Override
    public String getShipType() {
        return "submarine";
    }

    @Override
    public String toString() {
        if (super.isSunk()) {
            return "x";
        }

        return ".";
    }
}