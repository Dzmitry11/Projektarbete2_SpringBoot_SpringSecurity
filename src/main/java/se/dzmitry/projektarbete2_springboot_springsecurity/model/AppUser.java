package se.dzmitry.projektarbete2_springboot_springsecurity.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Entity class representing a user in the system.
 * This class is mapped to a database table using JPA.
 */
@Entity
public class AppUser {

    /**
     * Unique identifier for the user, automatically generated.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Username of the user.
     */
    private String username;

    /**
     * Encrypted password of the user.
     */
    private String password;

    /**
     * Gets the unique ID of the user.
     * @return The user ID.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique ID of the user.
     * @param id The new user ID.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Role assigned to the user (e.g., ROLE_USER, ROLE_ADMIN, ROLE_MANAGER).
     */
    private String role;

    /**
     * Sets the role for the user.
     * @param role The new role.
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Gets the role assigned to the user.
     * @return The user's role.
     */
    public String getRole() {
        return role;
    }

    /**
     * Gets the username of the user.
     * @return The username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user.
     * @param username The new username.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the encrypted password of the user.
     * @return The password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the encrypted password of the user.
     * @param password The new password.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
