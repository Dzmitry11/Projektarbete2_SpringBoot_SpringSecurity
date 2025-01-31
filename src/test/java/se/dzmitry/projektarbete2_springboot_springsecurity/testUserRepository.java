package se.dzmitry.projektarbete2_springboot_springsecurity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import se.dzmitry.projektarbete2_springboot_springsecurity.db.UserRepos;
import se.dzmitry.projektarbete2_springboot_springsecurity.model.AppUser;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class projektarbete2SpringBootSpringSecurityApplicationTests {

    @Autowired
    private UserRepos userRepos;

    @Test
    void contextLoads() {
    }

    @Test
    void testUserRepository() {
        // Создаем нового пользователя
        AppUser user = new AppUser();
        user.setUsername("testUser");
        user.setPassword("password");
        user.setRole("USER");

        // Сохраняем пользователя
        userRepos.save(user);

        // Проверяем, что пользователь был сохранен
        AppUser foundUser = userRepos.findByUsername("testUser");
        assertNotNull(foundUser);
    }
}

