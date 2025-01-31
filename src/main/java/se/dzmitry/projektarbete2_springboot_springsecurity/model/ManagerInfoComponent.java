package se.dzmitry.projektarbete2_springboot_springsecurity.model;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManagerInfoComponent {
    public List<ManagerInfo> getManagerInfos() {
        return List.of(
                new ManagerInfo("Manager Info 1", "Cameras activity"),
                new ManagerInfo("Manager Info 2", "Move detectors activity"),
                new ManagerInfo("Manager Info 3", "Smoke detectors activity"),
                new ManagerInfo("Manager Info 4", "Doors detector activity"),
                new ManagerInfo("Manager Info 5", "Alarm activity"),
                new ManagerInfo("Manager Info 6", "Objects details")
                );
    }
}



