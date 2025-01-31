package se.dzmitry.projektarbete2_springboot_springsecurity;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuration class for MVC settings.
 * Allows adding simple view controllers without implementing a full controller.
 */
    @Configuration
    public class MvcConfig implements WebMvcConfigurer {

    /**
     * Registers view controllers that map URLs directly to view templates.
     *
     * @param registry The ViewControllerRegistry for adding view mappings.
     */
        @Override
        public void addViewControllers(ViewControllerRegistry registry) {

        }
    }

