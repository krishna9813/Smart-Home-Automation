package p1;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Scheduler {
    private List<ScheduledTask> tasks = new ArrayList<>();
    private SmartHomeHub hub;

    public Scheduler(SmartHomeHub hub) {
        this.hub = hub;
    }

    public void setSchedule(int deviceId, String time, String command) {
        LocalTime taskTime = LocalTime.parse(time);
        tasks.add(new ScheduledTask(deviceId, taskTime, command));
    }

    public void runScheduledTasks() {
        LocalTime now = LocalTime.now();
        for (ScheduledTask task : tasks) {
            if (!task.isExecuted() && task.getTime().isBefore(now)) {
                // Execute the command
                executeCommand(task.getDeviceId(), task.getCommand());
                task.setExecuted(true);
            }
        }
    }

    private void executeCommand(int deviceId, String command) {
        switch (command) {
            case "Turn On":
                hub.turnOnDevice(deviceId);
                break;
            case "Turn Off":
                hub.turnOffDevice(deviceId);
                break;
            case "Lock":
                hub.lockDevice(deviceId);
                break;
            case "Unlock":
                hub.unlockDevice(deviceId);
                break;
            default:
                System.out.println("Unknown command: " + command);
        }
      
    }
}

class ScheduledTask {
    private int deviceId;
    private LocalTime time;
    private String command;
    private boolean executed;

    public ScheduledTask(int deviceId, LocalTime time, String command) {
        this.deviceId = deviceId;
        this.time = time;
        this.command = command;
        this.executed = false;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getCommand() {
        return command;
    }

    public boolean isExecuted() {
        return executed;
    }

    public void setExecuted(boolean executed) {
        this.executed = executed;
    }
}
