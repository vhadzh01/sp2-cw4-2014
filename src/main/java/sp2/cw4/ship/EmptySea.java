package sp2.cw4.ship;

public class EmptySea extends Ship {

    public EmptySea() {
        super.length = 1;
    }

    @Override
    public boolean shootAt(int row, int column) {
        super.hit[0] = true;
        return false;
    }

    @Override
    public boolean isSunk() {
        return false;
    }

    @Override
    public String getShipType() {
        return "empty";
    }

    @Override
    public String toString() {
        return super.wasHit() ? "-" : ".";
    }
}