package p1;

public class DeviceProxy extends Device {
    private DeviceObserver deviceObserver;

    public DeviceProxy(DeviceObserver deviceObserver) {
        super(deviceObserver.getId(), deviceObserver.getType());
        this.deviceObserver = deviceObserver;
    }

    public Device getDevice() {
        return deviceObserver.getDevice();
    }

    @Override
    public String getStatus() {
        return deviceObserver.getStatus();
    }

    @Override
    public void turnOn() {
        deviceObserver.turnOn();
    }

    @Override
    public void turnOff() {
        deviceObserver.turnOff();
    }

    public void setTemperature(int temperature) {
        if (deviceObserver.getDevice() instanceof Thermostat) {
            ((Thermostat) deviceObserver.getDevice()).setTemperature(temperature);
        }
    }
}
