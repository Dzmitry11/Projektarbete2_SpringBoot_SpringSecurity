package se.dzmitry.projektarbete2_springboot_springsecurity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import se.dzmitry.projektarbete2_springboot_springsecurity.db.UserRepos;
import se.dzmitry.projektarbete2_springboot_springsecurity.model.AppUser;
import java.util.ArrayList;
import java.util.List;

/**
 * Custom implementation of UserDetailsService for Spring Security authentication.
 */
@Component
public class UserLogin implements UserDetailsService {

    private UserRepos userRepos;

    /**
     * Constructor for injecting the user repository.
     *
     * @param userRepos Repository for accessing user data.
     */
    public UserLogin(UserRepos userRepos) {
        this.userRepos = userRepos;
    }

    /**
     * Loads a user by their username and converts it to a UserDetails object for authentication.
     *
     * @param username The username of the user attempting to log in.
     * @return UserDetails containing user credentials and roles.
     * @throws UsernameNotFoundException if the user is not found in the database.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = userRepos.findByUsername(username);
        List<GrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority(appUser.getRole()));

        if (appUser != null) {
            return new User(appUser.getUsername(), appUser.getPassword(),
                    true, true, true,
                    true, list);





        }
        throw new UsernameNotFoundException((username + " not found"));
    }
}

