package se.dzmitry.projektarbete2_springboot_springsecurity.web;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import se.dzmitry.projektarbete2_springboot_springsecurity.model.Camera;
import se.dzmitry.projektarbete2_springboot_springsecurity.model.Detector;

import java.util.Arrays;
import java.util.List;

    @Controller
    public class StuffsController {

        @GetMapping("/user/stuffs")
        public String userPage(Model model) {
            // Cameras
            List<Camera> cameras = Arrays.asList(
                    new Camera("Entrance Camera", "http://stream1.com"),
                    new Camera("Main Hall Camera", "http://stream2.com"),
                    new Camera("Back Door Camera", "http://stream3.com")
            );

            // Detectors
            List<Detector> detectors = Arrays.asList(
                    new Detector("Motion Detector", true, false),
                    new Detector("Smoke Detector", true, true),
                    new Detector("Door Detector", true, false),
                    new Detector("Window Detector", true, false)
            );

            // Alarm status
            boolean alarmEnabled = true;
            boolean alarmActive = false;

            model.addAttribute("cameras", cameras);
            model.addAttribute("detectors", detectors);
            model.addAttribute("alarmEnabled", alarmEnabled);
            model.addAttribute("alarmActive", alarmActive);
            return "stuffs";
        }
    }

