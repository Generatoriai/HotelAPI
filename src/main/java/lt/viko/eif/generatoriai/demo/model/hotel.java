package lt.viko.eif.generatoriai.demo.model;

import java.util.List;

public class hotel {
    private String title;
    private float star;
    private String addres;
    private int id;
    private String price;
    private List<String> roomTypeNames;
    private List<String> features;
    private List<Transport> transportList;
    private float rating;
    private int reviews; //kiek zmoniu reitingavo

    public hotel(String title, float star, String addres, int id, String price, List<String> roomTypeNames, List<String> features, List<Transport> transportList, float rating, int reviews) {
        this.title = title;
        this.star = star;
        this.addres = addres;
        this.id = id;
        this.price = price;
        this.roomTypeNames = roomTypeNames;
        this.features = features;
        this.transportList = transportList;
        this.rating = rating;
        this.reviews = reviews;
    }

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

    public String getPrice() { return price; }

    public void setPrice(String price) { this.price = price; }

    public List<String> getRoomTypeNames() { return roomTypeNames; }

    public void setRoomTypeNames(List<String> roomTypeNames) { this.roomTypeNames = roomTypeNames; }

    public List<String> getFeatures() { return features; }

    public void setFeatures(List<String> features) { this.features = features; }

    public List<Transport> getTransportList() {
        return transportList;
    }

    public void setTransportList(List<Transport> transportList) {
        this.transportList = transportList;
    }

    public float getRating() { return rating; }

    public void setRating(float rating) { this.rating = rating; }

    public int getReviews() { return reviews; }

    public void setReviews(int reviews) { this.reviews = reviews; }
}
