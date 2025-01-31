package se.dzmitry.projektarbete2_springboot_springsecurity.db;

import org.springframework.data.jpa.repository.JpaRepository;
import se.dzmitry.projektarbete2_springboot_springsecurity.model.AppUser;

/**
 * Repository interface for managing AppUser entities in the database.
 * Extends JpaRepository to provide standard CRUD operations.
 */
public interface UserRepos extends JpaRepository<AppUser, Long> {

    /**
     * Finds a user by their username.
     *
     * @param username The username of the user.
     * @return The AppUser entity if found, otherwise null.
     */
    public AppUser findByUsername(String username);
}

