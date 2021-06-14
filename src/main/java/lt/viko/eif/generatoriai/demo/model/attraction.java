package lt.viko.eif.generatoriai.demo.model;

/**
 * Attraction class.
 * @version 1.0
 * @since 1.0
 * @author Arminas M. Denis M. Goda M. Lukas A. Deividas K.
 */
public class attraction {
    private String title;

    /**
     * Constructor of attraction class
     * @param title - String name of a place
     */
    public attraction(String title) {
        this.title = title;
    }

    /**
     * Getter for a name of a place.
     *
     * @return String name of a place.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter for a name of a place.
     *
     * @param title - String name of a place
     */
    public void setTitle(String title) {
        this.title = title;
    }
}
