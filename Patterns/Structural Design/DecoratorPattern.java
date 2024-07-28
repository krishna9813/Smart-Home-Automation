// Component interface
interface Device {
    void assemble();
}

// Concrete Component
class BasicDevice implements Device {
    @Override
    public void assemble() {
        System.out.print("Basic Device.");
    }
}

// Decorator class
class DeviceDecorator implements Device {
    protected Device decoratedDevice;

    public DeviceDecorator(Device device) {
        this.decoratedDevice = device;
    }

    @Override
    public void assemble() {
        this.decoratedDevice.assemble();
    }
}

// Concrete Decorators
class LightDecorator extends DeviceDecorator {
    public LightDecorator(Device device) {
        super(device);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.print(" Adding features of Light.");
    }
}

class DoorLockDecorator extends DeviceDecorator {
    public DoorLockDecorator(Device device) {
        super(device);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.print(" Adding features of Door Lock.");
    }
}

class ThermostatDecorator extends DeviceDecorator {
    public ThermostatDecorator(Device device) {
        super(device);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.print(" Adding features of Thermostat.");
    }
}

// Main class to demonstrate the Decorator pattern
public class DecoratorPattern {
    public static void main(String[] args) {
        Device basicDevice = new BasicDevice();
        
        Device lightDevice = new LightDecorator(basicDevice);
        Device doorLockDevice = new DoorLockDecorator(basicDevice);
        Device thermostatDevice = new ThermostatDecorator(basicDevice);
        
        System.out.println("Light Device:");
        lightDevice.assemble();
        
        System.out.println("\nDoor Lock Device:");
        doorLockDevice.assemble();
        
        System.out.println("\nThermostat Device:");
        thermostatDevice.assemble();
    }
}
