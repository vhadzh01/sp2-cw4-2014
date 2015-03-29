package sp2.cw4.ship;

public class Cruiser extends Ship {

    public Cruiser() {
        super.length = 3;
    }

    @Override
    public String getShipType() {
        return "cruiser";
    }

    @Override
    public String toString() {
        if (super.isSunk()) {
            return "x";
        }
        else if (super.wasHit()) {
            return "S";
        }

        return ".";
    }
}