package lt.viko.eif.generatoriai.demo.model;

import java.util.List;

public class hotel {
    private String title;
    private float star;
    private String addres;
    private int id;
    private String name;
    private String price;
    private List<String> roomTypeNames;
    private String features;
    private List<Transport> transports;
    private int rating;
    private int reviews; //kiek zmoniu reitingavo x

    public hotel(String title, float star, String addres, int id, String name, String price, List<String> roomTypeNames, String features,
                 List<Transport> transports, int rating, int reviews) {
        this.title = title;
        this.star = star;
        this.addres = addres;
        this.id = id;
        this.name = name;
        this.price = price;
        this.roomTypeNames = roomTypeNames;
        this.features = features;
        this.transports = transports;
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

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getPrice() { return price; }

    public void setPrice(String price) { this.price = price; }

    public List<String> getRoomTypeNames() { return roomTypeNames; }

    public void setRoomTypeNames(List<String> roomTypeNames) { this.roomTypeNames = roomTypeNames; }

    public String getFeatures() { return features; }

    public void setFeatures(String features) { this.features = features; }

    public List<Transport> getTransports() { return transports; }

    public void setTransports(List<Transport> transports) { this.transports = transports; }

    public int getRating() { return rating; }

    public void setRating(int rating) { this.rating = rating; }

    public int getReviews() { return reviews; }

    public void setReviews(int reviews) { this.reviews = reviews; }
}
