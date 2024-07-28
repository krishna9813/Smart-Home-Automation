package p1;

public class Thermostat extends Device {
    private int temperature;

    public Thermostat(int id, int temperature) {
        super(id, "thermostat");
        this.temperature = temperature;
    }

    @Override
    public String getStatus() {
        return "Thermostat " + getId() + " is set to " + temperature + " degrees";
    }

    @Override
    public void turnOn() {
        // Not applicable for thermostat, you can leave it empty or implement some logic if needed
    }

    @Override
    public void turnOff() {
        // Not applicable for thermostat, you can leave it empty or implement some logic if needed
    }

    public int getTemperature() {
        return temperature;
    }

    @Override
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
}
