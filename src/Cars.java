import java.awt.*;

public abstract class Cars implements Movable {

    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private int direction; //direction of car in degrees
    private double x;
    private double y;
    private double length; //Length of car in meters

    public Cars(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, int direction, double x, double y, double length) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
        this.direction = direction;
        this.x = x;
        this.y = y;
        this.length=length;
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

    public void setXPosition(double x){
        this.x = x;
    }

    public double getYPosition(){
        return y;
    }

    public void setYPosition(double y){
        this.y = y;
    }

    abstract double speedFactor();

    public double getLength(){
        return length;
    }


    /**
     * moves the object in a direction
     */
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