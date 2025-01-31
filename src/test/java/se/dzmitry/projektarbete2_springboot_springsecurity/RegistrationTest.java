package se.dzmitry.projektarbete2_springboot_springsecurity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import se.dzmitry.projektarbete2_springboot_springsecurity.UserRepos.UserRepository;
import se.dzmitry.projektarbete2_springboot_springsecurity.model.AppUser;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")

public class RegistrationTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void testRegistration() {
        String username = "testUser";
        String password = "testPassword";
        AppUser user = new AppUser();
        user.setUsername(username);
        //lösenordet hashas med passwordEncoders metod encode()
        user.setPassword(passwordEncoder.encode(password));
        userRepository.saveAndFlush(user);

        //2. försöka att logga in med användaren med nedanstående kod
        try {
            mockMvc.perform(formLogin("/login")
                            .user(username)
                            .password(password))
                    .andExpect(status().is3xxRedirection())  // Förvänta omdirigering vid lyckad inloggning
                    .andExpect(redirectedUrl("/"));  // Omdirigeras till startsidan efter inloggning
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
