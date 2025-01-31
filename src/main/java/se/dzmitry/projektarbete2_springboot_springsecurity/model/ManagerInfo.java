package se.dzmitry.projektarbete2_springboot_springsecurity.model;

public class ManagerInfo {
    private String title;
    private String infoText;

    public ManagerInfo(String title, String infoText) {
        this.title = title;
        this.infoText = infoText;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getInfoText() {
        return infoText;
    }
    public void setInfoText(String infoText) {

    }
}
