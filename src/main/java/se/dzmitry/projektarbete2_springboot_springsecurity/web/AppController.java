package se.dzmitry.projektarbete2_springboot_springsecurity.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import se.dzmitry.projektarbete2_springboot_springsecurity.model.AdminDocument;
import se.dzmitry.projektarbete2_springboot_springsecurity.model.AdminDocumentComponent;
import se.dzmitry.projektarbete2_springboot_springsecurity.model.ManagerInfo;
import se.dzmitry.projektarbete2_springboot_springsecurity.model.ManagerInfoComponent;

import java.util.List;

/**
 * Controller responsible for handling page navigation and displaying content for users, managers, and admins.
 */
@org.springframework.stereotype.Controller
public class AppController {

    private final AdminDocumentComponent adminDocumentComponent;
    private final ManagerInfoComponent managerInfoComponent;

    /**
     * Constructor to inject dependencies for managing admin documents and manager info.
     *
     * @param adminDocumentComponent Component handling administrative documents.
     * @param managerInfoComponent Component managing manager-specific information.
     */
    public AppController(AdminDocumentComponent adminDocumentComponent, ManagerInfoComponent managerInfoComponent) {
        this.adminDocumentComponent = adminDocumentComponent;
        this.managerInfoComponent = managerInfoComponent;
    }

    /**
     * Handles requests to the home page.
     *
     * @return The name of the home page template (index.html).
     */
    @GetMapping("/")
    public String index() {
        return "index";
    }

    /**
     * Handles requests to the user page and provides the authenticated username.
     *
     * @param model The model to store attributes for the view.
     * @return The name of the user page template (user.html).
     */
    @GetMapping("/user")
    public String user(Model model) {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", authentication.getName());
        return "user";
    }

    /**
     * Handles requests to the admin page and provides a list of administrative documents.
     *
     * @param model The model to store attributes for the view.
     * @return The name of the admin page template (admin.html).
     */
    @GetMapping("/admin")
    public String admin(Model model) {
        List<AdminDocument> documents = adminDocumentComponent.getAdminDocuments();
        model.addAttribute("documents", documents);
        return "admin";
    }

    /**
     * Handles requests to the manager page and provides manager-specific information.
     *
     * @param model The model to store attributes for the view.
     * @return The name of the manager page template (manager.html).
     */
    @GetMapping("/manager")
    public String manager(Model model) {
        List<ManagerInfo> infoText = managerInfoComponent.getManagerInfos();
        model.addAttribute("infoText", infoText);
        return "manager";
    }
}
