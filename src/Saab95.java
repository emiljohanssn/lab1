import java.awt.*;

public class Saab95 extends Cars{

    public boolean turboOn;

    public Saab95(){
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
        turboOn = false;
        modelName = "Saab95";
        direction=0;
        x=0;
        y=0;
        stopEngine();
    }

    //Bara Saab
    public void setTurboOn(){
        turboOn = true;
    }

    //Bara SAAB
    public void setTurboOff(){
        turboOn = false;
    }

    private double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    private void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    private void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        if (amount < 0.0 || amount > 1.0) {
            throw new IllegalArgumentException("Amount must be between 0.0 and 1.0!!");
        } else if ((getCurrentSpeed() + speedFactor() * amount) > enginePower) {
            throw new IllegalArgumentException("Gas exceeds engine power!!");
        }
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        if (amount < 0.0 || amount > 1.0) {
            throw new IllegalArgumentException("Amount must be between 0.0 and 1.0!!");
        } else if ((getCurrentSpeed() - speedFactor() * amount) < 0.0) {
            throw new IllegalArgumentException("Brake makes negative speed!!");
        }
        decrementSpeed(amount);
    }
}