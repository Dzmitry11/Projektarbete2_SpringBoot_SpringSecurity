package se.dzmitry.projektarbete2_springboot_springsecurity.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import se.dzmitry.projektarbete2_springboot_springsecurity.UserRepos.UserRepository;
import se.dzmitry.projektarbete2_springboot_springsecurity.dto.UserRegistrationDto;

/**
 * Service class for managing user-related operations such as registration.
 */
@Service
public class UserService {

    /**
     * Repository for handling database operations related to users.
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * Password encoder for securely storing passwords.
     */
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Registers a new user in the system.
     *
     * @param registrationDto Data Transfer Object containing user registration details.
     * @return The newly created AppUser object.
     * @throws Exception if the username already exists.
     */
    public AppUser registerNewUser(UserRegistrationDto registrationDto) throws Exception {
        // Check if username already exists
        if (userRepository.findByUsername(registrationDto.getUsername()).isPresent()) {
            throw new Exception("Username already exists");
        }
        
        // Create new user
        AppUser user = new AppUser();
        user.setUsername(registrationDto.getUsername());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        user.setRole("ROLE_USER"); // Default role
        
        // Save and return the new user
        return userRepository.save(user);
    }
}
