package lt.viko.eif.generatoriai.demo.model;

public class hotel {
    private String title;
    private float star;
    private String addres;
    private int id;

    public hotel(String title, float star, String addres, int id) {
        this.title = title;
        this.star = star;
        this.addres = addres;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getStar() {
        return star;
    }

    public void setStar(float star) {
        this.star = star;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
