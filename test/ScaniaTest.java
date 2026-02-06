import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScaniaTest {
    Scania truck;

    @BeforeEach
    void setUp() {
        truck = new Scania();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void raiseAndLowerFlatbed() {
        assertEquals(0,truck.getFlatbed() );
        truck.raiseFlatbed(20);
        assertEquals(20, truck.getFlatbed());
        truck.lowerFlatbed(10);
        assertEquals(10, truck.getFlatbed());
    }

    @Test
    public void illegalFlatbedAngles() {
        assertEquals(0,truck.getFlatbed() );
        assertThrows(IllegalArgumentException.class, () ->
                truck.raiseFlatbed(71));
        assertThrows(IllegalArgumentException.class, () ->
                truck.lowerFlatbed(200));
    }

    @Test
    public void assertNotAbleToRaiseAndLowerFlatbedWhileDriving() {
        truck.startEngine();
        truck.gas(0.8);
        assertThrows(IllegalArgumentException.class, () -> {
            truck.raiseFlatbed(50);
        });
    }

    @Test
    public void assertNotAbleToDriveWhileRaisedFlatbed() {
        truck.raiseFlatbed(50);
        assertThrows(IllegalArgumentException.class, () -> {
            truck.startEngine();
        });
    }
}