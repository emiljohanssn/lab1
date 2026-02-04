import java.awt.*;

public class Saab951 extends Cars1 {

    private boolean turboOn;

    public Saab951(){
        super(2, 125, 0, Color.red, "Saab95", 0, 0, 0);
        turboOn = false;
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

    public boolean getTurboStatus() {return turboOn;}

    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

    private void incrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount);
    }

    private void decrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() - speedFactor() * amount);
    }

    public void gas(double amount){
        if (amount < 0.0 || amount > 1.0) {
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
}