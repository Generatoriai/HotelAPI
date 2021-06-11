package lt.viko.eif.generatoriai.demo.model;

import java.util.List;

/**
 * Transport class.
 */
public class Transport {
    private String title;
    private List<String> addres;

    /**
     * Information about transport in a city.
     *
     * @param title - String name of a transport type
     * @param addres - String List of addresses
     */
    public Transport(String title, List<String> addres) {
        this.title = title;
        this.addres = addres;
    }

    /**
     * Getter for a name of a transport place.
     *
     * @return String type title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter for a name of a transport place.
     *
     * @param title - String title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Getter for a list of addresses.
     *
     * @return String List of addresses
     */
    public List<String> getAddres() {
        return addres;
    }

    /**
     * Setter for a list of addresses.
     * @param addres - String List of addresses
     */
    public void setAddres(List<String> addres) {
        this.addres = addres;
    }
}
