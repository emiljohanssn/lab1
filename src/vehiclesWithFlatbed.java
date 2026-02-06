import java.awt.*;

abstract class vehiclesWithFlatbed extends Cars {
    private int flatbed;

    public vehiclesWithFlatbed(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, int direction, double x, double y, double length) {
        super(nrDoors, enginePower, currentSpeed, color, modelName, direction, x, y, length);
        flatbed = 0;
    }

    @Override
    public void startEngine() {
        if (flatbed != 0) {
            throw new IllegalArgumentException("You can't drive while you flatbed is not up!");
        }
        setCurrentSpeed(0.1);
    }

    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

    private void incrementSpeed(double amount) {
        setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount);
    }

    private void decrementSpeed(double amount) {
        setCurrentSpeed(getCurrentSpeed() - speedFactor() * amount);
    }

    public void gas(double amount){
        if (flatbed != 0) {
            throw new IllegalArgumentException("You can't drive while your flatbed is not straight");
        } else if (amount < 0.0 || amount > 1.0) {
            throw new IllegalArgumentException("Amount must be between 0.0 and 1.0!!");
        } else if ((getCurrentSpeed() + speedFactor() * amount) > getEnginePower()) {
            throw new IllegalArgumentException("Gas exceeds engine power!!");
        } else if (((getCurrentSpeed() + speedFactor() * amount) - getCurrentSpeed()) < 0.0) {
            throw new IllegalArgumentException("The gas results in lower speed!!");
        }
        incrementSpeed(amount);
    }

    public void brake(double amount){
        if (amount < 0.0 || amount > 1.0) {
            throw new IllegalArgumentException("Amount must be between 0.0 and 1.0!!");
        } else if ((getCurrentSpeed() - speedFactor() * amount) < 0.0) {
            throw new IllegalArgumentException("Brake makes negative speed!!");
        } else if (((getCurrentSpeed() - speedFactor() * amount) - getCurrentSpeed()) > 0.0) {
            throw new IllegalArgumentException("The break results in higher speed!!");
        }
        decrementSpeed(amount);
    }

    public int getFlatbed(){
        return flatbed;
    }

    public void setFlatbed(int flatbed){
        this.flatbed = flatbed;
    }
}