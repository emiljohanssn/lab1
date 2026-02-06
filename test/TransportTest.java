import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransportTest {
    Transport transport;
    Cars car1;
    Cars car2;

    @BeforeEach
    void setUp() {
        transport = new Transport();
        car1 = new Saab95();
        car2 = new Volvo240();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void lowerFlatbed() {
        transport.lowerFlatbed(1);
        assertEquals(1,transport.getFlatbed());
    }

    @Test
    public void raiseFlatbed() {
        transport.lowerFlatbed(1);
        transport.raiseFlatbed(2);
        assertEquals(0,transport.getFlatbed());
    }

    @Test
    public void loadCarsSuccessfully() {
        transport.lowerFlatbed(3094);
        transport.load(car1);
        assertEquals(1, transport.getTransportCount());
    }

    @Test
    public void unloadCarsSuccessfully() {
        transport.lowerFlatbed(3094);
        transport.load(car1);
        transport.load(car2);
        transport.unload();
        assertEquals(1, transport.getTransportCount());
    }

    @Test
    public void checkCarsMoveWithTransport() {
        transport.lowerFlatbed(3094);
        transport.load(car1);
        transport.raiseFlatbed(309);
        transport.startEngine();
        transport.gas(0.5);
        transport.move();
        assertEquals(3.95, car1.getXPosition());
    }
}