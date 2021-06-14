package lt.viko.eif.generatoriai.demo.model;

/**
 * Class for hotel's feedback information.
 * @version 1.0
 * @since 1.0
 * @author Arminas M. Denis M. Goda M. Lukas A. Deividas K.
 */
public class reiting {
    private String summary;
    private String title;
    private float rating;
    private String qualitativeBadgeText;

    /**
     * All the necessary information about guests' feedback about hotel.
     *
     * @param summary - comment about hotel
     * @param title - short description about comment
     * @param rating - rating
     * @param qualitativeBadgeText - short feedback status
     */
    public reiting(String summary, String title, float rating, String qualitativeBadgeText) {
        this.summary = summary;
        this.title = title;
        this.rating = rating;
        this.qualitativeBadgeText = qualitativeBadgeText;
    }

    /**
     * Getter for a comment about hotel.
     *
     * @return String type comment
     */
    public String getSummary() {
        return summary;
    }

    /**
     * Setter for a comment about hotel.
     * @param summary - String comment
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * Getter for a short description of a comment.
     *
     * @return String type title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter for a short description of a comment.
     *
     * @param title - String title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Getter for rating.
     *
     * @return float type rating
     */
    public float getRating() {
        return rating;
    }

    /**
     * Setter for rating.
     *
     * @param rating - float rating
     */
    public void setRating(float rating) {
        this.rating = rating;
    }

    /**
     * Getter for a short description of comments status.
     *
     * @return String type status
     */
    public String getQualitativeBadgeText() {
        return qualitativeBadgeText;
    }

    /**
     * Setter for a short description of comments status.
     *
     * @param qualitativeBadgeText - String status
     */
    public void setQualitativeBadgeText(String qualitativeBadgeText) {
        this.qualitativeBadgeText = qualitativeBadgeText;
    }
}
