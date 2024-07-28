package p1;

public class DeviceObserver extends Device implements Observer {
    private Device device;

    public DeviceObserver(Device device) {
        super(device.getId(), device.getType());
        this.device = device;
    }

    @Override
    public void update() {
       //
    }

    @Override
    public String getStatus() {
        return device.getStatus();
    }

    @Override
    public void turnOn() {
        device.turnOn();
    }

    @Override
    public void turnOff() {
        device.turnOff();
    }

    public Device getDevice() {
        return device;
    }
}
