import java.awt.*;

public class Scania extends vehiclesWithFlatbed implements hasFlatbed {

    public Scania(){
        super(2, 770, 0, Color.black, "Scania", 0, 0, 0, 6);
        stopEngine();
    }

    public void raiseFlatbed(int amount) {
        if (getFlatbed() + amount > 70) {
            throw new IllegalArgumentException("Angle can't be bigger than 70!!");
        } else if (getCurrentSpeed() != 0) {
            throw new IllegalArgumentException("The truck is moving!!");
        }
        setFlatbed(getFlatbed() + amount);
    }

    public void lowerFlatbed(int amount) {
        if (getFlatbed() - amount < 0) {
            throw new IllegalArgumentException("Angle can't be smaller than 0!!");
        }
        setFlatbed(getFlatbed() - amount);
    }
}
