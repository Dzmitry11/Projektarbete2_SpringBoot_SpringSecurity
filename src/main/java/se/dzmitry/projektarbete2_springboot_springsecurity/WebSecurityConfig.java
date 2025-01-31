package se.dzmitry.projektarbete2_springboot_springsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configuration class for Spring Security.
 * Defines security settings and access control rules for the application.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    /**
     * Configures security filter chain, defining authentication and authorization settings.
     *
     * @param http HttpSecurity object for configuring security settings.
     * @return SecurityFilterChain object.
     * @throws Exception if an error occurs while configuring security.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {  // Enables default form-based login

        http.formLogin(Customizer.withDefaults());

        // Define access control rules for different endpoints
        http.authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/register").permitAll()
                .requestMatchers("/admin").hasAnyRole("ADMIN", "MANAGER")
                .requestMatchers("/user").hasAnyRole("USER", "MANAGER", "ADMIN")
                .requestMatchers("/manager").hasAnyRole( "MANAGER")
                .requestMatchers("/user/stuffs").hasAnyRole("USER", "ADMIN", "MANAGER")
                .anyRequest().authenticated()); // Require authentication for all other requests
        return http.build();
    }

    /**
     * Defines a password encoder bean for encoding user passwords securely.
     *
     * @return BCryptPasswordEncoder instance.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}