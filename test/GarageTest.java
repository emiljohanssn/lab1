import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GarageTest {
    private Garage garage;
    private Cars saab95_1;
    private Cars saab95_2;
    private Cars saab95_3;

    @BeforeEach
    void setUp() {
        garage = new Garage(2);
        saab95_1 = new Saab95();
        saab95_2 = new Saab95();
        saab95_3 = new Saab95();
    }

    @AfterEach
    void tearDown() {
    }
    
    @Test
    public void assertLoadMaxAndThanReachCapacity(){
        garage.load(saab95_1);
        assertEquals(1, garage.getCurrentCapacity());
        garage.load(saab95_2);
        assertEquals(2, garage.getCurrentCapacity());
        assertThrows(IllegalStateException.class,
                () -> garage.load(saab95_3));
        assertEquals(2, garage.getCurrentCapacity());
    }

    @Test
    public void assertUnloadCorrectly(){
        garage.load(saab95_1);
        assertEquals(1, garage.getCurrentCapacity());
        assertInstanceOf(Saab95.class, garage.unload());
        assertEquals(0, garage.getCurrentCapacity());
    }
}