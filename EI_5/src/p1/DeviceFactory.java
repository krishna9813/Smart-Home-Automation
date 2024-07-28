package p1;

public class DeviceFactory {
    public static Device createDevice(int id, String type, String status, Integer temperature) {
        switch (type) {
            case "light":
                return new Light(id, status);
            case "thermostat":
                return new Thermostat(id, temperature);
            case "door":
                return new DoorLock(id, status);
            default:
                throw new IllegalArgumentException("Unknown device type: " + type);
        }
    }
}
