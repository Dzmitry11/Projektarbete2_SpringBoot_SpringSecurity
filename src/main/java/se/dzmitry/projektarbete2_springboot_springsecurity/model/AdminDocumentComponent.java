package se.dzmitry.projektarbete2_springboot_springsecurity.model;
import org.springframework.stereotype.Component;
import java.util.List;

/**Component responsible for managing a list of administrative documents.**/
@Component
public class AdminDocumentComponent {

    /** Component responsible for managing a list of administrative documents.
     *
     * @return A list of AdminDocument objects.
     */
    public List<AdminDocument> getAdminDocuments(){
        return List.of(
                new AdminDocument("Admin Doc 1", "Cameras"),
                new AdminDocument("Admin Doc 2", "Move detectors"),
                new AdminDocument("Admin Doc 3", "Smoke detectors"),
                new AdminDocument("Admin Doc 4", "Doors detectors"),
                new AdminDocument("Admin Doc 5", "Alarm"),
                new AdminDocument("Admin Doc 6", "Objects")

        );
    }
}
