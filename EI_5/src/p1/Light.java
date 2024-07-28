// Light.java
package p1;

public class Light extends Device {
    private String status;

    public Light(int id, String status) {
        super(id, "light");
        this.status = status;
    }

    @Override
    public String getStatus() {
        return "Light " + getId() + " is " + status;
    }

    @Override
    public void turnOn() {
        status = "on";
    }

    @Override
    public void turnOff() {
        status = "off";
    }
}
