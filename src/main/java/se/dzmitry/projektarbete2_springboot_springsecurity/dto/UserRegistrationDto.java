package se.dzmitry.projektarbete2_springboot_springsecurity.dto;

/**
 * Data Transfer Object (DTO) for user registration.
 * This class is used to capture user input during the registration process.
 */
public class UserRegistrationDto {
    private String username; // Username of the registering user
    private String password; // Password of the registering user

    /**
     * Gets the username.
     * @return the username of the user.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username.
     * @param username the new username for the user.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password.
     * @return the password of the user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     * @param password the new password for the user.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
