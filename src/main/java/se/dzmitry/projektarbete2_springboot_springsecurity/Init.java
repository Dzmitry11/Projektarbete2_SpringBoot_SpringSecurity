package se.dzmitry.projektarbete2_springboot_springsecurity;

import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import se.dzmitry.projektarbete2_springboot_springsecurity.db.UserRepos;
import se.dzmitry.projektarbete2_springboot_springsecurity.model.AppUser;

/**
 * Initializes the application with default users if the database is empty.
 */
@Component
    public class Init {
        private UserRepos userRepos;
        private PasswordEncoder passwordEncoder;

    /**
     * Constructor for dependency injection.
     *
     * @param userRepos Repository for managing user entities.
     * @param passwordEncoder Encoder for encrypting user passwords.
     */
        public Init(UserRepos userRepos, PasswordEncoder passwordEncoder) {
            this.userRepos = userRepos;
            this.passwordEncoder = passwordEncoder;
        }

    /**
     * Method executed after the application starts.
     * Adds default users to the database if no users exist.
     */
        @PostConstruct
        public void init() {
            // Check if the database contains any users
            if (userRepos.findAll().isEmpty()) {

                // Create and save an admin
                AppUser user = new AppUser();
                user.setPassword(passwordEncoder.encode("1234"));
                user.setUsername("Dzmitry");
                user.setRole("ROLE_ADMIN");
                userRepos.save(user);

                // Create and save a manager
                AppUser user2 = new AppUser();
                user2.setPassword(passwordEncoder.encode("12345"));
                user2.setUsername("Hokan");
                user2.setRole("ROLE_MANAGER");
                userRepos.save(user2);

                // Create and save a regular user
                AppUser user3 = new AppUser();
                user3.setPassword(passwordEncoder.encode("12346"));
                user3.setUsername("Tom");
                user3.setRole("ROLE_USER");
                userRepos.save(user3);
            }
        }
    }

