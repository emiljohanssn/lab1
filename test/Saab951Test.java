import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class Saab951Test {
    Saab951 car;

    @BeforeEach
    void setUp() {
        car = new Saab951();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void speedZeroAfterStopEngine() {
        car.startEngine();
        assertEquals(0.1, car.getCurrentSpeed());
        car.stopEngine();
        assertEquals(0, car.getCurrentSpeed());
    }

    @Test
    public void turnRightAndCheckDirection() {
        car.startEngine();
        assertEquals(0, car.getDirection());
        car.turnRight();
        assertEquals(270, car.getDirection());
    }

    @Test
    public void moveInXPositionAndYPosition() {
        car.startEngine();
        car.gas(1.0);
        assertEquals(1.35, car.getCurrentSpeed());
        car.move();
        assertEquals(0, car.getYPosition());
        car.turnRight();
        assertEquals(270, car.getDirection());
    }

    @Test
    public void turnLeftAndMoveInYPosition() {
        car.startEngine();
        car.gas(0.3);
        assertEquals(0.475, car.getCurrentSpeed());
        car.turnLeft();
        assertEquals(90, car.getDirection());
        car.move();
        assertEquals(0.475, car.getYPosition());
        assertEquals(0, car.getXPosition(), 1e-12);
    }

    @Test
    public void assureTurboAndBreakWorks() {
        car.startEngine();
        car.setTurboOn();
        assertTrue(car.getTurboStatus());
        car.gas(0.75);
        assertEquals(1.31875, car.getCurrentSpeed());
        car.gas(1.0);
        assertEquals(2.94375, car.getCurrentSpeed());
        car.brake(0.1);
        assertEquals(2.78125, car.getCurrentSpeed());
        car.setTurboOff();
        car.brake(0.15);
        assertEquals(2.59375, car.getCurrentSpeed(), 1e-12);
    }

    @Test
    public void GetAndSetColorDoorsEnginePowerModelName() {
        car.setColor(Color.YELLOW);
        assertEquals(Color.YELLOW, car.getColor());
        assertEquals(2, car.getNrDoors());
        assertEquals(125, car.getEnginePower());
        assertEquals("Saab95", car.getModelName());
    }

    @Test
    public void assertGasAndBreakOnlyAcceptsBetweenZeroAndOne() {
        car.startEngine();
        assertThrows(IllegalArgumentException.class, () -> {
            car.gas(1.5);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            car.brake(1.1);
        });
    }

    @Test
    public void assertCurrentSpeedIsBetweenZeroAndEnginePower() {
        car.startEngine();
        assertThrows(IllegalArgumentException.class, () -> {
            car.brake(0.8);
        });
    }
}