import java.util.ArrayList;
import java.util.List;

// Subject interface
interface Subject {
    void attach(Observer o);
    void detach(Observer o);
    void notifyObservers();
}

// Concrete Subject
class SmartHomeHub implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private int temperature;

    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    public int getTemperature() {
        return temperature;
    }
}

// Observer interface
interface Observer {
    void update();
}

// Concrete Observer
class Device implements Observer {
    private String name;

    public Device(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        System.out.println(name + " received temperature update.");
    }
}

// Main class to demonstrate the Observer pattern
public class ObserverPattern {
    public static void main(String[] args) {
        SmartHomeHub hub = new SmartHomeHub();
        Device light = new Device("Light");
        Device thermostat = new Device("Thermostat");

        hub.attach(light);
        hub.attach(thermostat);

        hub.setTemperature(25);
        hub.setTemperature(30);
    }
}
