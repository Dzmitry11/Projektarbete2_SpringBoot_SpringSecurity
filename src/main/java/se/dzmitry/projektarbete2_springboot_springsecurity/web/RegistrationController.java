package se.dzmitry.projektarbete2_springboot_springsecurity.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.dzmitry.projektarbete2_springboot_springsecurity.dto.UserRegistrationDto;
import se.dzmitry.projektarbete2_springboot_springsecurity.model.UserService;

/**
 * Controller responsible for handling user registration.
 */
@Controller
public class RegistrationController {
    private final UserService userService;

    /**
     * Constructor to inject the UserService dependency.
     *
     * @param userService The service responsible for user-related operations.
     */
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Displays the registration form.
     *
     * @param model The model to store attributes for the view.
     * @return The name of the registration form template (Register.html).
     */
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        // Add any necessary attributes to the model
        return "Register"; // Make sure this matches the exact case of your template file
    }

    /**
     * Handles user registration.
     *
     * @param username The username entered by the user.
     * @param password The password entered by the user.
     * @param model The model to store attributes for the view.
     * @return A redirect to the user page upon successful registration, or the registration page with an error message.
     */
    @PostMapping("/register")
    public String registerUser(@RequestParam String username,
                             @RequestParam String password,
                             Model model) {
        try {
            UserRegistrationDto registrationDto = new UserRegistrationDto();
            registrationDto.setUsername(username);
            registrationDto.setPassword(password);
            
            userService.registerNewUser(registrationDto);
            return "redirect:/user"; // Redirect to the user page after successful registration
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "Register"; // Make sure this matches the exact case of your template file
        }
    }
}
