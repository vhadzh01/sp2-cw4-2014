package sp2.cw4.ship;

import sp2.cw4.Ocean;

abstract public class Ship {

    private int bowRow = 0;
    private int bowColumn = 0;
    protected int length = 0;
    private boolean horizontal = false;
    protected boolean[] hit = new boolean[4];

    public int getBowRow() {
        return bowRow;
    }

    public void setBowRow(int bowRow) {
        this.bowRow = bowRow;
    }

    public int getBowColumn() {
        return bowColumn;
    }

    public void setBowColumn(int bowColumn) {
        this.bowColumn = bowColumn;
    }

    public boolean isHorizontal() {
        return horizontal;
    }

    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }

    /**
     * Only used for testing
     */
    void setHits(int hits) {
        for (int i = 0; i < hits; i++) {
            hit[i] = true;
        }
    }

    protected boolean wasHit() {
        for (int i = 0; i < hit.length; i++) {
            if (hit[i]) {
                return true;
            }
        }
        return false;
    }

    public int getLength() {
        return this.length;
    }

    /**
     *
     * Abstract method to be overridden in implementation classes
     *
     * @return
     */
    abstract public String getShipType();

    public boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {

        int maxValue = 9;

        int above = row == 0 ? 0 : row-1;
        int below = row == 9 ? 9 : row+1;
        int leftSide = column == 0 ? 0 : column-1;
        int rightSide = column == 9 ? 9 : column+1;

        for (int i = 0; i < length; i++) {

            boolean isOccupied;

            if (horizontal) {

                if (column + i > maxValue) {
                    return false;
                }

                isOccupied = ocean.isOccupied(above, column + i) || ocean.isOccupied(row, column + i) || ocean.isOccupied(below, column + i);
            }
            else {

                if (row + i > maxValue) {
                    return false;
                }

                isOccupied = ocean.isOccupied(row + i, leftSide) || ocean.isOccupied(row + i, column) || ocean.isOccupied(row + i, rightSide);
            }

            if (isOccupied) {
                return false;
            }
        }

        if (
                ocean.isOccupied(leftSide, above) ||
                ocean.isOccupied(leftSide, below) ||
                ocean.isOccupied(rightSide, above) ||
                ocean.isOccupied(rightSide, below)
            ) {
            return false;
        }

        return true;
    }

    public void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
        this.bowRow = row;
        this.bowColumn = column;
        this.horizontal = horizontal;

        for (int i = 0; i < length; i++) {
            if (horizontal) {
                ocean.addShip(this, row, column + i);
            }
            else {
                ocean.addShip(this, row + i, column);
            }
        }
    }

    public boolean shootAt(int row, int column) {

        if (!isSunk()) {
            for (int i = 0; i < length; i++) {

                int shipRow = this.bowRow;
                int shipColumn = this.bowColumn + i;

                if (!this.horizontal) {
                    shipRow = this.bowRow + i;
                    shipColumn = this.bowColumn;
                }

                if (row == shipRow && column == shipColumn) {
                    this.hit[i] = true;
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isSunk() {
        for (int i = 0; i < this.length; i++) {
            if (!hit[i]) {
                return false;
            }
        }
        return true;
    }
}
