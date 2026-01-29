import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class Saab95Test {
    Saab95 car;

    @BeforeEach
    void setUp() {
        car = new Saab95();
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
        car.gas(20);
        assertEquals(25.1, car.getCurrentSpeed());
        car.move();
        assertEquals(0, car.getYPosition());
        car.turnRight();
        assertEquals(270, car.getDirection());
    }

    @Test
    public void turnLeftAndMoveInYPosition() {
        car.startEngine();
        car.gas(30);
        assertEquals(37.6, car.getCurrentSpeed());
        car.turnLeft();
        assertEquals(90, car.getDirection());
        car.move();
        assertEquals(37.6, car.getYPosition());
        assertEquals(0, car.getXPosition(), 1e-12);
    }

    @Test
    public void assureTurboAndBreakWorks() {
        car.startEngine();
        car.setTurboOn();
        assertTrue(car.turboOn);
        car.gas(20);
        assertEquals(32.6, car.getCurrentSpeed());
        car.brake(10);
        assertEquals(16.35, car.getCurrentSpeed());
        car.setTurboOff();
        car.brake(10);
        assertEquals(3.85, car.getCurrentSpeed(), 1e-12);
    }

    @Test
    public void GetAndSetcolorDoorsEnginepower() {
        car.setColor(Color.YELLOW);
        assertEquals(Color.YELLOW, car.getColor());
        assertEquals(2, car.getNrDoors());
        assertEquals(125, car.getEnginePower());
    }
}