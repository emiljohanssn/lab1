import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Volvo240Test {
    Volvo240 car;
    @BeforeEach
    void setUp() {
        car = new Volvo240();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void TestVolvo240GasAndBrake() {
        car.startEngine();
        assertEquals(0.1, car.getCurrentSpeed());
        car.gas(0.5);
        assertEquals(6.35, car.getCurrentSpeed());
        car.brake(2.0);
        assertEquals(3.85, car.getCurrentSpeed(), 1e-12);
        car.stopEngine();
        assertEquals(0, car.getCurrentSpeed());
    }


}
