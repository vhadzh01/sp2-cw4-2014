package sp2.cw4.ship;

public class Battleship extends Ship {

    public Battleship() {
        super.length = 4;
    }

    @Override
    public String getShipType() {
        return "battleship";
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