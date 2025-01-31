package se.dzmitry.projektarbete2_springboot_springsecurity.UserRepos;

import org.springframework.data.jpa.repository.JpaRepository;
import se.dzmitry.projektarbete2_springboot_springsecurity.model.AppUser;

import java.util.Optional;

/**
 * Repository interface for managing user entities in the database.
 * Extends JpaRepository to provide standard CRUD operations.
 */
public interface UserRepository extends JpaRepository<AppUser, Long> {

    /**
     * Finds a user by their username.
     *
     * @param username The username of the user to find.
     * @return An Optional containing the AppUser if found, otherwise empty.
     */
    Optional<AppUser> findByUsername(String username);
}

