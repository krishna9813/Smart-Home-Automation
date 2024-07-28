package p1;

import java.util.HashMap;
import java.util.Map;

public class SmartHomeHub extends Subject {
    private Map<Integer, DeviceProxy> devices = new HashMap<>();
    private Scheduler scheduler;
    private Automation automation;

    public SmartHomeHub() {
        this.scheduler = new Scheduler(this);
        this.automation = new Automation(this);
    }

    public Map<Integer, DeviceProxy> getDevices() {
        return devices;
    }

    public void addDevice(int id, String type, String status, Integer temperature) {
        Device device = DeviceFactory.createDevice(id, type, status, temperature);
        DeviceObserver deviceObserver = new DeviceObserver(device);
        DeviceProxy deviceProxy = new DeviceProxy(deviceObserver);
        devices.put(id, deviceProxy);
        attach(deviceObserver);
        System.out.println("Device added: ID = " + id + ", Type = " + type + ", Status = " + status);
    }

    public void removeDevice(int id) {
        DeviceProxy deviceProxy = devices.remove(id);
        if (deviceProxy != null) {
            DeviceObserver deviceObserver = (DeviceObserver) deviceProxy.getDevice();
            detach(deviceObserver);
            System.out.println("Device removed: ID = " + id);
        } else {
            System.out.println("Device with ID " + id + " not found.");
        }
    }

    public void turnOnDevice(int id) {
        devices.get(id).turnOn();
        notifyObservers();
        System.out.println("Device turned on: ID = " + id);
    }

    public void turnOffDevice(int id) {
        devices.get(id).turnOff();
        notifyObservers();
        System.out.println("Device turned off: ID = " + id);
    }

    public void lockDevice(int id) {
        if (devices.get(id).getDevice() instanceof DoorLock) {
            ((DoorLock) devices.get(id).getDevice()).lock();
            notifyObservers();
            System.out.println("Device locked: ID = " + id);
        } else {
            System.out.println("Device with ID " + id + " is not a door lock.");
        }
    }

    public void unlockDevice(int id) {
        if (devices.get(id).getDevice() instanceof DoorLock) {
            ((DoorLock) devices.get(id).getDevice()).unlock();
            notifyObservers();
            System.out.println("Device unlocked: ID = " + id);
        } else {
            System.out.println("Device with ID " + id + " is not a door lock.");
        }
    }

    public void setSchedule(int id, String time, String command) {
        scheduler.setSchedule(id, time, command);
        System.out.println("Schedule set: Device ID = " + id + ", Time = " + time + ", Command = " + command);
    }

    public String getStatusReport() {
        StringBuilder statusReport = new StringBuilder();
        for (DeviceProxy device : devices.values()) {
            statusReport.append(device.getStatus()).append(". ");
        }
        return statusReport.toString();
    }

    public void runScheduledTasks() {
        scheduler.runScheduledTasks();
        System.out.println("Scheduled tasks executed.");
    }

    public void addTrigger(String condition, String action) {
        automation.addTrigger(condition, action);
        System.out.println("Trigger added: Condition = " + condition + ", Action = " + action);
    }

    public void checkTriggers() {
        automation.checkTriggers();
        System.out.println("Triggers checked.");
    }
}
