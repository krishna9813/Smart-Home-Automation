// Singleton class
class SmartHomeHub {
    private static SmartHomeHub instance;

    private SmartHomeHub() {}

    public static SmartHomeHub getInstance() {
        if (instance == null) {
            instance = new SmartHomeHub();
        }
        return instance;
    }

    public void showStatus() {
        System.out.println("Smart Home Hub is operational.");
    }
}

// Main class to demonstrate the Singleton pattern
public class SingletonPattern {
    public static void main(String[] args) {
        SmartHomeHub hub = SmartHomeHub.getInstance();
        hub.showStatus();
    }
}
