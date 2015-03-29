package sp2.cw4.ship;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BattleshipTest extends ShipTest {

    @Before
    public void setUp() {
        underTest = new Battleship();
    }

    @Test
    public void testPlaceShipAtWhenHorizontal() {

        underTest.placeShipAt(1, 1, true, ocean);

        verify(ocean).addShip(underTest, 1, 1);
        verify(ocean).addShip(underTest, 1, 2);
        verify(ocean).addShip(underTest, 1, 3);
        verify(ocean).addShip(underTest, 1, 4);
    }

    @Test
    public void testPlaceShipAtWhenVertical() {

        underTest.placeShipAt(1, 1, false, ocean);

        verify(ocean).addShip(underTest, 1, 1);
        verify(ocean).addShip(underTest, 2, 1);
        verify(ocean).addShip(underTest, 3, 1);
        verify(ocean).addShip(underTest, 4, 1);
    }

    @Test
    public void testShootAtWhenHorizontal() {

        super.testShootAtWhenHorizontal(3);
    }

    @Test
    public void testShootAtWhenVertical() {

        super.testShootAtWhenVertical(3);
    }

    @Test
    public void testGetShipType() throws Exception {

        assertEquals("battleship", underTest.getShipType());
    }

    @Test
    public void testToStringWhenSunk() throws Exception {

        underTest.setHits(4);

        assertEquals("x", underTest.toString());
    }

    @Test
    public void testToStringWhenHit() throws Exception {

        underTest.setHits(3);

        assertEquals("S", underTest.toString());
    }

    @Test
    public void testToStringWhenNotHit() throws Exception {

        assertEquals(".", underTest.toString());
    }
}