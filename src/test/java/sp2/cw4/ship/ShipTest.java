package sp2.cw4.ship;

import org.junit.Test;
import org.mockito.Mock;
import sp2.cw4.Ocean;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

abstract public class ShipTest {

    @Mock
    protected Ocean ocean;

    protected Ship underTest;

    @Test
    public void testOkToPlaceShipAtWhenHorizontalAndPlaceOccupied() {

        when(ocean.isOccupied(0, 0)).thenReturn(true);

        boolean result = underTest.okToPlaceShipAt(0, 0, true, ocean);

        assertFalse(result);
    }

    @Test
    public void testOkToPlaceShipAtWhenVerticalAndPlaceOccupied() {

        when(ocean.isOccupied(underTest.getLength()-1, 0)).thenReturn(true);

        boolean result = underTest.okToPlaceShipAt(0, 0, false, ocean);

        assertFalse(result);
    }

    @Test
    public void testOkToPlaceShipAtWhenHorizontalAndPlaceNotOccupied() {

        when(ocean.isOccupied(0, underTest.getLength()-1)).thenReturn(false);

        boolean result = underTest.okToPlaceShipAt(0, 0, true, ocean);

        assertTrue(result);
    }

    @Test
    public void testOkToPlaceShipAtWhenVerticalAndPlaceNotOccupied() {

        when(ocean.isOccupied(1, 1)).thenReturn(false);

        boolean result = underTest.okToPlaceShipAt(2, 2, false, ocean);

        assertTrue(result);
    }

    @Test
    public void testOkToPlaceShipAtWhenPlaceNextToIsNotOccupied() {

        when(ocean.isOccupied(0, 0)).thenReturn(false);

        boolean result = underTest.okToPlaceShipAt(1, 1, false, ocean);

        assertTrue(result);
    }

    @Test
    public void testOkToPlaceShipAtWhenPlaceOnLeftAboveOccupied() {

        when(ocean.isOccupied(4, 4)).thenReturn(true);

        boolean result = underTest.okToPlaceShipAt(5, 5, false, ocean);

        assertFalse(result);
    }

    @Test
    public void testOkToPlaceShipAtWhenPlacingTooLongShipOnBoundariesAndHorizontal() {

        boolean result = underTest.okToPlaceShipAt(10, 10, true, ocean);

        assertFalse(result);
    }

    @Test
    public void testOkToPlaceShipAtWhenPlacingTooLongShipOnBoundariesAndVertical() {

        boolean result = underTest.okToPlaceShipAt(10, 10, false, ocean);

        assertFalse(result);
    }

    @Test
    public void testShootAtWhenSunk() {

        underTest.setHits(4);

        boolean result = underTest.shootAt(0, 0);

        assertFalse(result);
    }

    public void testShootAtWhenHorizontal(int column) {

        underTest.setBowRow(0);
        underTest.setBowColumn(0);
        underTest.setHorizontal(true);

        boolean result = underTest.shootAt(0, column);

        assertTrue(result);
    }

    public void testShootAtWhenVertical(int column) {

        underTest.setBowRow(0);
        underTest.setBowColumn(0);
        underTest.setHorizontal(false);

        boolean result = underTest.shootAt(column, 0);

        assertTrue(result);
    }
}
