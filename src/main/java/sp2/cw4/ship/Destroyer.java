package sp2.cw4.ship;

public class Destroyer extends Ship {

    public Destroyer() {
        super.length = 2;
    }

    @Override
    public String getShipType() {
        return "destroyer";
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