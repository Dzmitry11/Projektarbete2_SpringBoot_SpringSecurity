package se.dzmitry.projektarbete2_springboot_springsecurity.model;

/** Represents an administrative document with a title and description.**/
public class AdminDocument {
    private String title;// Title of the document
    private String description;// Description of the document

    /**
     * Constructor to initialize an AdminDocument with a title and description.
     *
     * @param title The title of the document.
     * @param description The description of the document.
     */
    public AdminDocument(String title, String description) {
        this.title = title;
        this.description = description;
    }

    /**
     * Gets the title of the document.
     *
     * @return The document title.
     */
    public String getTitle() {
        return title;

    }

    /**
     * Sets the title of the document.
     *
     * @param title The new title of the document.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the description of the document.
     *
     * @return The document description.
     */
    public String getDescription() {
        return description;

    }
    /**
     * Sets the description of the document.
     *
     * @param description The new description of the document.
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
