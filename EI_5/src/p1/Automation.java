package p1;

import java.util.List;
import java.util.ArrayList;

public class Automation {
    private List<Trigger> triggers = new ArrayList<>();
    private SmartHomeHub hub;

    public Automation(SmartHomeHub hub) {
        this.hub = hub;
    }

    public void addTrigger(String condition, String action) {
        triggers.add(new Trigger(condition, action));
        System.out.println("Trigger added: Condition = " + condition + ", Action = " + action);
    }

    public void checkTriggers() {
        for (Trigger trigger : triggers) {
            System.out.println("Checking trigger: Condition = " + trigger.getCondition() + ", Action = " + trigger.getAction());
            if (evaluateCondition(trigger.getCondition())) {
                System.out.println("Condition met: " + trigger.getCondition());
                executeAction(trigger.getAction());
            }
        }
    }

    private boolean evaluateCondition(String condition) {
        String[] parts = condition.split(" ");
        if (parts.length != 3) {
            System.out.println("Invalid condition format: " + condition);
            return false;
        }

        String attribute = parts[0];
        String operator = parts[1];
        String value = parts[2];

        for (DeviceProxy deviceProxy : hub.getDevices().values()) {
            Device device = deviceProxy.getDevice();
            System.out.println("Evaluating device: ID = " + device.getId() + ", Type = " + device.getType());

            if (attribute.equals("temperature") && device.getType().equalsIgnoreCase("thermostat")) {
                Thermostat thermostat = (Thermostat) device;
                int currentTemperature = thermostat.getTemperature();
                System.out.println("Current temperature: " + currentTemperature);
                int targetTemperature = Integer.parseInt(value);
                switch (operator) {
                    case ">":
                        if (currentTemperature > targetTemperature) return true;
                        break;
                    case "<":
                        if (currentTemperature < targetTemperature) return true;
                        break;
                    case "==":
                        if (currentTemperature == targetTemperature) return true;
                        break;
                    default:
                        System.out.println("Unknown operator: " + operator);
                }
            } else {
                System.out.println("Attribute mismatch or device type mismatch");
            }
        }

        return false;
    }

    private void executeAction(String action) {
        System.out.println("Executing action: " + action);
        String[] parts = action.split(" ");
        if (parts.length != 2) {
            System.out.println("Invalid action format: " + action);
            return;
        }

        String command = parts[0];
        int deviceId = Integer.parseInt(parts[1]);
     
        DeviceProxy deviceProxy = hub.getDevices().get(deviceId);
        if (deviceProxy == null) {
            System.out.println("Device not found: ID = " + deviceId);
            return;
        }

        switch (command) {
            case "turnOn":
                deviceProxy.turnOn();
                break;
            case "turnOff":
                deviceProxy.turnOff();
                break;
            // Add more cases as needed
        }

        System.out.println("Action executed: " + command + " on device ID = " + deviceId);
        hub.notifyObservers();
    }
}

class Trigger {
    private String condition;
    private String action;

    public Trigger(String condition, String action) {
        this.condition = condition;
        this.action = action;
    }

    public String getCondition() {
        return condition;
    }

    public String getAction() {
        return action;
    }
}
