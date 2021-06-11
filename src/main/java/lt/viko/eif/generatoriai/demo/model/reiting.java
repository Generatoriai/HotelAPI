package lt.viko.eif.generatoriai.demo.model;

public class reiting {
    private String summary;
    private String title;
    private float rating;
    private String qualitativeBadgeText;

    public reiting(String summary, String title, float rating, String qualitativeBadgeText) {
        this.summary = summary;
        this.title = title;
        this.rating = rating;
        this.qualitativeBadgeText = qualitativeBadgeText;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getQualitativeBadgeText() {
        return qualitativeBadgeText;
    }

    public void setQualitativeBadgeText(String qualitativeBadgeText) {
        this.qualitativeBadgeText = qualitativeBadgeText;
    }
}
