package sp2.cw4;

import sp2.cw4.ship.Battleship;
import sp2.cw4.ship.Cruiser;
import sp2.cw4.ship.Destroyer;
import sp2.cw4.ship.EmptySea;
import sp2.cw4.ship.Ship;
import sp2.cw4.ship.Submarine;

import java.util.Random;

public class Ocean {

    private static int NUMBER_OF_SHIPS = 10;

    private Ship[][] ships = new Ship[10][10];
    private int shotsFired = 0;
    private int hitCount = 0;
    private int shipsSunk = 0;

    public Ocean() {

        for (int i = 0; i < ships.length; i++) {
            for (int j = 0; j < ships[i].length; j++) {
                ships[i][j] = new EmptySea();
            }
        }
    }

    public void placeAllShipsRandomly() {

        placeShip(new Battleship());

        placeShip(new Cruiser());
        placeShip(new Cruiser());

        placeShip(new Destroyer());
        placeShip(new Destroyer());
        placeShip(new Destroyer());

        placeShip(new Submarine());
        placeShip(new Submarine());
        placeShip(new Submarine());
        placeShip(new Submarine());
    }

    private void placeShip(Ship ship) {
        boolean shipIsPlaced = false;
        while (!shipIsPlaced) {

            int row = new Random().nextInt(10);
            int column = new Random().nextInt(10);
            boolean horizontal = new Random().nextBoolean();

            if (ship.okToPlaceShipAt(row, column, horizontal, this)) {
                ship.placeShipAt(row, column, horizontal, this);
                shipIsPlaced = true;
            }
        }
    }

    public boolean isOccupied(int row, int column) {
       return !ships[row][column].getShipType().equals("empty");
    }

    public boolean shootAt(int row, int column) {

        shotsFired++;

        Ship ship = ships[row][column];
        if (ship.shootAt(row, column)) {

            hitCount++;

            if (ship.isSunk()) {
                System.out.println("You just sank a ");
            }

            return true;
        }

        return false;
    }

    public int getShotsFired() {
        return shotsFired;
    }

    public int getHitCount() {
        return hitCount;
    }

    public int getShipsSunk() {
        return shipsSunk;
    }

    public boolean isGameOver() {
        return shipsSunk >= NUMBER_OF_SHIPS;
    }

    public void addShip(Ship ship, int row, int column) {
        this.ships[row][column] = ship;
    }

    public Ship[][] getShipArray() {
        return ships;
    }

    public void print() {

        System.out.print(" ");

        for (int i = 0; i < ships.length; i++) {
            System.out.print(" " + i);
        }

        System.out.print("\n");

        for (int i = 0; i < ships.length; i++) {

            System.out.print(i);

            for (int j = 0; j < ships[i].length; j++) {

                System.out.print(" " + ships[i][j].toString());
            }
            System.out.print("\n");
        }
    }
}
