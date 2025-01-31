package se.dzmitry.projektarbete2_springboot_springsecurity.model;

public class Detector {
    private String type; // Например, "Motion Detector", "Smoke Detector"
    private boolean enabled;
    private boolean active;

    public Detector(String type, boolean enabled, boolean active) {
        this.type = type;
        this.enabled = enabled;
        this.active = active;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
