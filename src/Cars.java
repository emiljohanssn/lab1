import java.awt.*;

public class Cars implements Movable {

    public int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    public Color color; // Color of the car
    public String modelName; // The car model name
    public int direction; //direction of car in degrees
    public double x;
    public double y;

    public int getNrDoors(){
        return nrDoors;
    }

    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    public int getDirection(){
        return direction;
    }

    public double getXPosition(){
        return x;
    }

    public double getYPosition(){
        return y;
    }

    public void move(){
        double radians = Math.toRadians(direction);

        x += Math.cos(radians) * currentSpeed;
        y += Math.sin(radians) * currentSpeed;
    }

    public void turnLeft(){
        direction = (direction + 90)%360;
    }

    public void turnRight(){
        direction = (direction + 270)%360;
    }
}