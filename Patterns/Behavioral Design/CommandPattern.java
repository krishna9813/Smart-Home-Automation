// Command interface
interface Command {
    void execute();
}

// Concrete Commands
class TurnOnCommand implements Command {
    private Device device;

    public TurnOnCommand(Device device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOn();
    }
}

class TurnOffCommand implements Command {
    private Device device;

    public TurnOffCommand(Device device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOff();
    }
}

// Invoker class
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

// Receiver class
abstract class Device {
    private int id;
    private String type;
    private String status;

    public Device(int id, String type, String status) {
        this.id = id;
        this.type = type;
        this.status = status;
    }

    public abstract void turnOn();
    public abstract void turnOff();
    public abstract String getStatus();
}

class Light extends Device {
    public Light(int id, String type, String status) {
        super(id, type, status);
    }

    @Override
    public void turnOn() {
        System.out.println("Light is turned on.");
    }

    @Override
    public void turnOff() {
        System.out.println("Light is turned off.");
    }

    @Override
    public String getStatus() {
        return "Light status: " + super.getStatus();
    }
}

class DoorLock extends Device {
    public DoorLock(int id, String type, String status) {
        super(id, type, status);
    }

    @Override
    public void turnOn() {
        System.out.println("Door is unlocked.");
    }

    @Override
    public void turnOff() {
        System.out.println("Door is locked.");
    }

    @Override
    public String getStatus() {
        return "Door status: " + super.getStatus();
    }
}

// Main class
public class CommandPattern {
    public static void main(String[] args) {
        Device light = new Light(1, "light", "off");
        Device door = new DoorLock(2, "door", "locked");

        Command turnOnLight = new TurnOnCommand(light);
        Command turnOffLight = new TurnOffCommand(light);
        Command unlockDoor = new TurnOnCommand(door);
        Command lockDoor = new TurnOffCommand(door);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(turnOnLight);
        remote.pressButton();

        remote.setCommand(unlockDoor);
        remote.pressButton();
    }
}
