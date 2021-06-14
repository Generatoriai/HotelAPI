package lt.viko.eif.generatoriai.demo.model;

import java.util.List;

/**
 * Hotel class.
 * @version 1.0
 * @since 1.0
 * @author Arminas M. Denis M. Goda M. Lukas A. Deividas K.
 */
public class Hotel {
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

    /**
     * All the necessary information about hotel. Details.
     *
     * @param title - name of a hotel
     * @param star - overall rating
     * @param addres - address of a hotel
     * @param id - hotel ID
     * @param price - lowest or most popular price to stay in a hotel
     * @param roomTypeNames - types of rooms existing in a hotels
     * @param features - hotels features
     * @param transportList - public transport to and out of hotel
     * @param rating - hotel rating which is based on the visitor
     * @param reviews - hotel reviews which is based on the visitor
     */
    public Hotel(String title, float star, String addres, int id, String price, List<String> roomTypeNames, List<String> features, List<Transport> transportList, float rating, int reviews) {
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

    /**
     * Basic info about hotel.
     *
     * @param title - name of a hotel
     * @param star - overall rating
     * @param addres - hotel address
     * @param id - hotel ID
     */
    public Hotel(String title, float star, String addres, int id) {
        this.title = title;
        this.star = star;
        this.addres = addres;
        this.id = id;
    }

    /**
     * Getter for a hotel name.
     *
     * @return String type hotel name/title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter for a hotel name.
     *
     * @param title - String hotel name
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Getter for an overall rating of a hotel.
     *
     * @return float type average rating.
     */
    public float getStar() {
        return star;
    }

    /**
     * Setter for an overall rating of a hotel.
     *
     * @param star - float average rating/star
     */
    public void setStar(float star) {
        this.star = star;
    }

    /**
     * Getter for an address of a hotel.
     *
     * @return String type address
     */
    public String getAddres() {
        return addres;
    }

    /**
     * Setter for an address of a hotel.
     *
     * @param addres - String address
     */
    public void setAddres(String addres) {
        this.addres = addres;
    }

    /**
     * Getter for ID of a hotel.
     *
     * @return int type hotel ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for ID of a hotel.
     *
     * @param id - int hotel ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for hotel's price.
     *
     * @return String type price with currency
     */
    public String getPrice() { return price; }

    /**
     * Setter for hotel's price.
     *
     * @param price - String price
     */
    public void setPrice(String price) { this.price = price; }

    /**
     * Getter for a list of room types existing in a hotel.
     *
     * @return String List of room types
     */
    public List<String> getRoomTypeNames() { return roomTypeNames; }

    /**
     * Setter for a list of room types existing in a hotel.
     *
     * @param roomTypeNames - String List of room types
     */
    public void setRoomTypeNames(List<String> roomTypeNames) { this.roomTypeNames = roomTypeNames; }

    /**
     * Getter for a list of hotel features.
     *
     * @return String List of hotel features
     */
    public List<String> getFeatures() { return features; }

    /**
     * Setter for a list of hotel features.
     *
     * @param features - String List of hotel features
     */
    public void setFeatures(List<String> features) { this.features = features; }

    /**
     * Getter for a list of public transport to and out of hotel.
     *
     * @return List of Transport classes
     */
    public List<Transport> getTransportList() {
        return transportList;
    }

    /**
     * Setter for a list of public transport to and out of hotel.
     *
     * @param transportList - List of Transport classes
     */
    public void setTransportList(List<Transport> transportList) {
        this.transportList = transportList;
    }

    /**
     * Getter for hotel rating
     *
     * @return hotel rating
     */
    public float getRating() { return rating; }

    /**
     * Setter for hotel rating
     *
     * @param rating - hotel rating in float type
     */
    public void setRating(float rating) { this.rating = rating; }

    /**
     * Getter for hotel reviews
     *
     * @return hotel reviews
     */
    public int getReviews() { return reviews; }

    /**
     * Setter for hotel reviews
     *
     * @param reviews - hotel reviews in Integer type
     */
    public void setReviews(int reviews) { this.reviews = reviews; }
}
