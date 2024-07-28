// Target interface
interface GenericDevice {
    void turnOn();
    void turnOff();
}

// Adaptee interfaces
interface LightDevice {
    void switchOn();
    void switchOff();
}

interface DoorLockDevice {
    void unlock();
    void lock();
}

interface ThermostatDevice {
    void heatOn();
    void heatOff();
}

// Adaptee implementations
class Light implements LightDevice {
    @Override
    public void switchOn() {
        System.out.println("Light is turned on.");
    }

    @Override
    public void switchOff() {
        System.out.println("Light is turned off.");
    }
}

class DoorLock implements DoorLockDevice {
    @Override
    public void unlock() {
        System.out.println("Door is unlocked.");
    }

    @Override
    public void lock() {
        System.out.println("Door is locked.");
    }
}

class Thermostat implements ThermostatDevice {
    @Override
    public void heatOn() {
        System.out.println("Thermostat heating is turned on.");
    }

    @Override
    public void heatOff() {
        System.out.println("Thermostat heating is turned off.");
    }
}

// Adapter classes
class LightAdapter implements GenericDevice {
    private LightDevice light;

    public LightAdapter(LightDevice light) {
        this.light = light;
    }

    @Override
    public void turnOn() {
        light.switchOn();
    }

    @Override
    public void turnOff() {
        light.switchOff();
    }
}

class DoorLockAdapter implements GenericDevice {
    private DoorLockDevice doorLock;

    public DoorLockAdapter(DoorLockDevice doorLock) {
        this.doorLock = doorLock;
    }

    @Override
    public void turnOn() {
        doorLock.unlock();
    }

    @Override
    public void turnOff() {
        doorLock.lock();
    }
}

class ThermostatAdapter implements GenericDevice {
    private ThermostatDevice thermostat;

    public ThermostatAdapter(ThermostatDevice thermostat) {
        this.thermostat = thermostat;
    }

    @Override
    public void turnOn() {
        thermostat.heatOn();
    }

    @Override
    public void turnOff() {
        thermostat.heatOff();
    }
}

// Main class to demonstrate the Adapter pattern
public class AdapterPattern{
    public static void main(String[] args) {
        LightDevice light = new Light();
        DoorLockDevice doorLock = new DoorLock();
        ThermostatDevice thermostat = new Thermostat();

        GenericDevice lightAdapter = new LightAdapter(light);
        GenericDevice doorLockAdapter = new DoorLockAdapter(doorLock);
        GenericDevice thermostatAdapter = new ThermostatAdapter(thermostat);

        lightAdapter.turnOn();
        lightAdapter.turnOff();

        doorLockAdapter.turnOn();
        doorLockAdapter.turnOff();

        thermostatAdapter.turnOn();
        thermostatAdapter.turnOff();
    }
}

