package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.*;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    Visitor visitor;
    Visitor visitor2;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        visitor = new Visitor(16, 166, 20);
        visitor2 = new Visitor(17, 140,15);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void canGetOnRollerCoaster() {
        assertTrue(rollerCoaster.isAllowedTo(visitor));
    }

    @Test
    public void canNotGetOnRollerCoaster() {
        assertFalse(rollerCoaster.isAllowedTo(visitor2));
    }

    @Test
    public void visitorChargedDoubleFee() {
        Visitor visitor = new Visitor(12, 201, 20);
        assertEquals(16.80, rollerCoaster.priceFor(visitor), 0.01);
    }

    @Test
    public void visitorUnder200ChargedNormalFee() {
        assertEquals(8.40,rollerCoaster.priceFor(visitor), 0.01);
    }
}
