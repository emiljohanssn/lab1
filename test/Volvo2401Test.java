import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Volvo2401Test {
    Volvo2401 car;
    @BeforeEach
    void setUp() {
        car = new Volvo2401();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void TestVolvo240GasAndBrake() {
        car.startEngine();
        assertEquals(0.1, car.getCurrentSpeed());
        car.gas(0.5);
        assertEquals(0.725, car.getCurrentSpeed());
        car.brake(0.2);
        assertEquals(0.475, car.getCurrentSpeed(), 1e-12);
        car.stopEngine();
        assertEquals(0, car.getCurrentSpeed());
    }
}
