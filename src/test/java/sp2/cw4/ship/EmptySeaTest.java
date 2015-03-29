package sp2.cw4.ship;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class EmptySeaTest extends ShipTest {

    @Before
    public void setUp() {
        underTest = new EmptySea();
    }

    @Test
    public void testShootAt() {

        boolean result = underTest.shootAt(0, 0);

        assertFalse(result);
    }

    @Test
    public void testGetShipType() throws Exception {

        assertEquals("empty", underTest.getShipType());
    }

    @Test
    public void testIsSunk() {
        assertFalse(underTest.isSunk());
    }

    @Test
    public void testToStringWhenSunk() throws Exception {

        underTest.setHits(1);

        assertEquals("-", underTest.toString());
    }

    @Test
    public void testToStringWhenNotHit() throws Exception {

        assertEquals(".", underTest.toString());
    }
}