package p1;
public abstract class Device {
    private int id;
    private String type;

    public Device(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public abstract String getStatus();
    public abstract void turnOn();

    public abstract void turnOff();
    public void setTemperature(int temperature) {
        throw new UnsupportedOperationException("setTemperature is not supported for this device");
    }
}


