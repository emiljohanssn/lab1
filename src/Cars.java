import java.awt.*;

abstract class Cars implements Movable {

    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private int direction; //direction of car in degrees
    private double x;
    private double y;

    public Cars(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, int direction, double x, double y) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
        this.direction = direction;
        this.x = x;
        this.y = y;
    }

    public String getModelName() {return modelName;}

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

    abstract double speedFactor();

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