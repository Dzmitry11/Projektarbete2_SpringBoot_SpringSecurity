package se.dzmitry.projektarbete2_springboot_springsecurity.model;

public class Camera {
    private String name;
    private String streamUrl;

    public Camera(String name, String streamUrl) {
        this.name = name;
        this.streamUrl = streamUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreamUrl() {
        return streamUrl;
    }

    public void setStreamUrl(String streamUrl) {
        this.streamUrl = streamUrl;
    }
}
