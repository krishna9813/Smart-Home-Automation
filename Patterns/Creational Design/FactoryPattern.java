// Product interface
interface Device {
    void turnOn();
    void turnOff();
}

// Concrete Products
class Light implements Device {
    @Override
    public void turnOn() {
        System.out.println("Light is turned on.");
    }

    @Override
    public void turnOff() {
        System.out.println("Light is turned off.");
    }
}

class Thermostat implements Device {
    @Override
    public void turnOn() {
        System.out.println("Thermostat is turned on.");
    }

    @Override
    public void turnOff() {
        System.out.println("Thermostat is turned off.");
    }
}

class DoorLock implements Device {
    @Override
    public void turnOn() {
        System.out.println("Door is unlocked.");
    }

    @Override
    public void turnOff() {
        System.out.println("Door is locked.");
    }
}

// Factory class
class DeviceFactory {
    public static Device createDevice(String type) {
        if (type == null) {
            return null;
        }
        if (type.equalsIgnoreCase("LIGHT")) {
            return new Light();
        } else if (type.equalsIgnoreCase("THERMOSTAT")) {
            return new Thermostat();
        } else if (type.equalsIgnoreCase("DOOR")) {
            return new DoorLock();
        }
        return null;
    }
}

// Main class to demonstrate the Factory pattern
public class FactoryPattern {
    public static void main(String[] args) {
        Device light = DeviceFactory.createDevice("LIGHT");
        light.turnOn();
        light.turnOff();

        Device thermostat = DeviceFactory.createDevice("THERMOSTAT");
        thermostat.turnOn();
        thermostat.turnOff();

        Device door = DeviceFactory.createDevice("DOOR");
        door.turnOn();
        door.turnOff();
    }
}
