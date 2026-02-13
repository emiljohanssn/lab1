import java.util.ArrayList;

public class Garage<C extends Cars> implements Storage<C> {
    private ArrayList<C> carGarage = new ArrayList<>();
    private int maxCapacity;

    public Garage(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    @Override
    public void load(C car) {
        if (carGarage.size() >= maxCapacity) {
            throw new IllegalStateException("Garage is full");
        }
        carGarage.add(car);
    }

    @Override
    public C unload() {
        if (!carGarage.isEmpty()) {
            return carGarage.removeFirst();
        }
        throw new IllegalStateException("No car in Garage");
    }

    public int getCurrentCapacity() {
        return carGarage.size();
    }

    public ArrayList<C> getCarGarage() {
        return carGarage;
    }
}