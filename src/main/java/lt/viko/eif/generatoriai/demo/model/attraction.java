package lt.viko.eif.generatoriai.demo.model;

/**
 * Attraction class.
 */
public class attraction {
    private String title;

    /**
     *
     * @param title
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
