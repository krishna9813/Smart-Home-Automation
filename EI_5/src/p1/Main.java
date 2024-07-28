package p1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SmartHomeHub hub = new SmartHomeHub();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Choose an option:");
            System.out.println("1. Add Device");
            System.out.println("2. Remove Device");
            System.out.println("3. Turn On Device");
            System.out.println("4. Turn Off Device");
            System.out.println("5. Lock Device");
            System.out.println("6. Unlock Device");
            System.out.println("7. Set Schedule");
            System.out.println("8. Add Trigger");
            System.out.println("9. Get Status Report");
            System.out.println("10. Run Scheduled Tasks");
            System.out.println("11. Check Triggers");
            System.out.println("12. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter device ID:");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Enter device type (light, thermostat, door):");
                    String type = scanner.nextLine();
                    String status = null;
                    Integer temperature = null;
                    if (type.equalsIgnoreCase("light") || type.equalsIgnoreCase("door")) {
                        System.out.println("Enter status (on/off for light, locked/unlocked for door):");
                        status = scanner.nextLine();
                    } else if (type.equalsIgnoreCase("thermostat")) {
                        System.out.println("Enter temperature:");
                        temperature = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                    }
                    hub.addDevice(id, type, status, temperature);
                    break;
                case 2:
                    System.out.println("Enter device ID to remove:");
                    int removeId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    hub.removeDevice(removeId);
                    break;
                case 3:
                    System.out.println("Enter device ID to turn on:");
                    int turnOnId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    hub.turnOnDevice(turnOnId);
                    break;
                case 4:
                    System.out.println("Enter device ID to turn off:");
                    int turnOffId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    hub.turnOffDevice(turnOffId);
                    break;
                case 5:
                    System.out.println("Enter device ID to lock:");
                    int lockId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    hub.lockDevice(lockId);
                    break;
                case 6:
                    System.out.println("Enter device ID to unlock:");
                    int unlockId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    hub.unlockDevice(unlockId);
                    break;
                case 7:
                    System.out.println("Enter device ID for scheduling:");
                    int scheduleId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Enter time (HH:MM):");
                    String time = scanner.nextLine();
                    System.out.println("Enter command (Turn On/Turn Off/Lock/Unlock):");
                    String command = scanner.nextLine();
                    hub.setSchedule(scheduleId, time, command);
                    break;
                case 8:
                    System.out.println("Enter condition for trigger:");
                    String condition = scanner.nextLine();
                    System.out.println("Enter action for trigger:");
                    String action = scanner.nextLine();
                    hub.addTrigger(condition, action);
                    break;
                case 9:
                    System.out.println("Status Report:");
                    System.out.println(hub.getStatusReport());
                    break;
                case 10:
                    hub.runScheduledTasks();
                    break;
                case 11:
                    hub.checkTriggers();
                    break;
                case 12:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
