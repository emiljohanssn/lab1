import java.awt.*;
public class Volvo240 extends Cars{

    private final static double trimFactor = 1.25;

    public Volvo240(){
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        direction = 0;
        x = 0;
        y = 0;
        stopEngine();
    }

    private double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }

    private void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        if (amount < 0.0 || amount > 1.0) {
            throw new IllegalArgumentException("Amount must be between 0.0 and 1.0.");
        } else if (Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower) > enginePower) {
            throw new IllegalArgumentException("Gas exceeds engine power!!");
        } else if ((Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower) - currentSpeed) < 0.0) {
            throw new IllegalArgumentException("The gas results in lower speed!!");
        }
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        if (amount < 0.0 || amount > 1.0) {
            throw new IllegalArgumentException("Amount must be between 0.0 and 1.0.");
        } else if (Math.max(getCurrentSpeed() - speedFactor() * amount,0) < 0.0) {
            throw new IllegalArgumentException("Brake makes negative speed!!");
        } else if (((Math.max(getCurrentSpeed() - speedFactor() * amount,0)) - currentSpeed) < 0.0) {
            throw new IllegalArgumentException("The break results in higher speed!!");
        }
        decrementSpeed(amount);
    }
}