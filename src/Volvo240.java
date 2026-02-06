import java.awt.*;

public class Volvo240 extends Cars {

    private final static double trimFactor = 1.25;

    public Volvo240(){
        super(4, 100, 0, Color.black, "Volvo240", 0, 0, 0, 2);
        stopEngine();
    }

    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

    private void incrementSpeed(double amount){
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower()));
    }

    private void decrementSpeed(double amount){
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount,0));
    }

    public void gas(double amount){
        if (amount < 0.0 || amount > 1.0) {
            throw new IllegalArgumentException("Amount must be between 0.0 and 1.0.");
        } else if (Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower()) > getEnginePower()) {
            throw new IllegalArgumentException("Gas exceeds engine power!!");
        } else if ((Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower()) - getCurrentSpeed()) < 0.0) {
            throw new IllegalArgumentException("The gas results in lower speed!!");
        }
        incrementSpeed(amount);
    }

    public void brake(double amount){
        if (amount < 0.0 || amount > 1.0) {
            throw new IllegalArgumentException("Amount must be between 0.0 and 1.0.");
        } else if (Math.max(getCurrentSpeed() - speedFactor() * amount,0) < 0.0) {
            throw new IllegalArgumentException("Brake makes negative speed!!");
        } else if (((Math.max(getCurrentSpeed() - speedFactor() * amount,0)) - getCurrentSpeed()) > 0.0) {
            throw new IllegalArgumentException("The break results in higher speed!!");
        }
        decrementSpeed(amount);
    }
}