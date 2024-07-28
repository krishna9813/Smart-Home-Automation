// DoorLock.java
package p1;

public class DoorLock extends Device {
    private String status;

    public DoorLock(int id, String status) {
        super(id, "door");
        this.status = status;
    }

    @Override
    public String getStatus() {
        return "Door " + getId() + " is " + status;
    }

    @Override
    public void turnOn() {
    	  status = "locked";
       
    }

    @Override
    public void turnOff() {
    	 status = "unlocked";
        
    }

    public void lock() {
        status = "locked";
    }

    public void unlock() {
        status = "unlocked";
    }
}
