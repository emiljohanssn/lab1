import java.awt.*;
import java.util.Stack;

public class Transport extends vehiclesWithFlatbed implements hasFlatbed, Storage<Cars>{
    private int capacity;
    private Stack<Cars> carsLoaded = new Stack<>();

    public Transport(){
        super(2, 770, 0, Color.red, "Transporter", 0, 0, 0, 14);
        capacity = 10;
        stopEngine();
    }

    public void raiseFlatbed(int amount) {
        if (getFlatbed() == 0) {
            throw new IllegalArgumentException("Flatbed is already up!!");
        }
        setFlatbed(0);
    }

    public void lowerFlatbed(int amount) {
        if (getFlatbed() == 1) {
            throw new IllegalArgumentException("Flatbed is already down!!");
        } else if (getCurrentSpeed() != 0) {
            throw new IllegalArgumentException("The truck is moving!!");
        }
        setFlatbed(1);
    }

    @Override
    public void load(Cars car) {
        if (getFlatbed() != 1) {
            throw new IllegalArgumentException("Flatbed is up!!");
        } else if ((Math.abs(this.getXPosition() - car.getXPosition()) +
                (Math.abs(this.getXPosition() - car.getXPosition()))) > 5) {
            throw new IllegalArgumentException("The car is to far away!!");
        } else if (carsLoaded.size() >= capacity) {
            throw new IllegalArgumentException("The transport is full!!");
        } else if (car.getLength() > 4) {
            throw new IllegalArgumentException("The car is to big!!");
        } else if (car instanceof Transport) {
            throw new IllegalArgumentException("A transport is not allowed to be loaded on another transport!!");
        }
        carsLoaded.add(car);
    }

    @Override
    public Cars unload() {
        if (carsLoaded.isEmpty()) {
            throw new IllegalArgumentException("The transport is empty!!");
        }
        Cars unloadedCar = (Cars) carsLoaded.pop();
        unloadedCar.setXPosition(unloadedCar.getXPosition() + 1);
        return unloadedCar;
    }

    public int getTransportCount() {
        return carsLoaded.size();
    }

    @Override
    public void move() {
        super.move();

        for (Cars car : carsLoaded) {
            car.setXPosition(this.getXPosition());
            car.setYPosition(this.getYPosition());
        }
    }
}

