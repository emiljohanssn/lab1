import java.awt.*;

abstract class Cars1 implements Movable1 {

    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private int direction; //direction of car in degrees
    private double x;
    private double y;

    public Cars1(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, int direction, double x, double y) {
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

    public void setCurrentSpeed(double currentSpeed){
        this.currentSpeed = currentSpeed;
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

    @Override
    public void move(){
        double radians = Math.toRadians(direction);

        x += Math.cos(radians) * currentSpeed;
        y += Math.sin(radians) * currentSpeed;
    }

    @Override
    public void turnLeft(){
        direction = (direction + 90)%360;
    }

    @Override
    public void turnRight(){
        direction = (direction + 270)%360;
    }
}