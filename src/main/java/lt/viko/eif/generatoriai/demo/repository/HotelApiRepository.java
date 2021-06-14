package lt.viko.eif.generatoriai.demo.repository;

import lt.viko.eif.generatoriai.demo.api.CoordinatesAPI;
import lt.viko.eif.generatoriai.demo.api.HotelAPI;
import lt.viko.eif.generatoriai.demo.api.InfoAPI;
import lt.viko.eif.generatoriai.demo.model.Transport;
import lt.viko.eif.generatoriai.demo.model.Hotel;
import lt.viko.eif.generatoriai.demo.model.attraction;
import lt.viko.eif.generatoriai.demo.model.reiting;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * HotelAPIRepository class. Used for extracting wanted responses from the API classes.
 * @version 1.0
 * @since 1.0
 * @author Arminas M. Denis M. Goda M. Lukas A. Deividas K.
 */
public class HotelApiRepository {
    private static String response;
    private static List<Hotel> listHotelMain;

    /**
     * Method for getting the lattitude from CoordinatesAPI class.
     * Parses the response to JSONObject to latitude and longitude
     * @param titleCountry name of the city to get coordinates from
     * @throws IOException Signals that an I/O exception of some sort has occurred.
     * @throws ParseException Signals that an error has been reached unexpectedly while parsing.
     */
    static void getLatitude(String titleCountry) throws IOException, ParseException {
        JSONParser parse = new JSONParser();
        JSONObject jsonObject = (JSONObject) parse.parse(CoordinatesAPI.getResponse(titleCountry));


        JSONArray jsonarr_1 = (JSONArray) jsonObject.get("results");
        for (int i = 0; i < jsonarr_1.size(); i++) {
            System.out.println(jsonarr_1.get(i));
        }

        JSONObject listObject = (JSONObject) jsonarr_1.get(0);
        JSONObject mainObject = (JSONObject) listObject.get("location");

        System.out.println("Longitude - " + mainObject.get("lng"));
        System.out.println("Latitude  - " + mainObject.get("lat"));

        //System.out.println(HotelAPI.getHotel((Double)mainObject.get("lat"), (Double) mainObject.get("lng")));
        //info all hotel
        response = HotelAPI.getHotel((Double) mainObject.get("lat"), (Double) mainObject.get("lng"));
    }

    /**
     * Method for getting information about hotel from the InfoAPI class.
     * Parses the Response to JSONObject and returns the information about hotel from the given ID.
     * @param id identification number of the hotel
     * @return
     * @throws IOException Signals that an I/O exception of some sort has occurred.
     * @throws ParseException Signals that an error has been reached unexpectedly while parsing.
     */
    public static Hotel getInfo(int id) throws IOException, ParseException {
        //info hotel one
        JSONParser parse = new JSONParser();
        JSONObject jsonObject = (JSONObject)parse.parse(InfoAPI.getHotelInfo(id));
        JSONObject jsonObject2 = (JSONObject) jsonObject.get("data");
        JSONObject jsonObject1 = (JSONObject) jsonObject2.get("body");
        JSONObject mainObj = (JSONObject) jsonObject1.get("propertyDescription");

        JSONObject jsonO = (JSONObject) mainObj.get("address");
        String address = String.valueOf(jsonO.get("fullAddress"));
        String titleHotel = String.valueOf(mainObj.get("name"));
        float ratingHotel = Float.parseFloat(String.valueOf(mainObj.get("starRating")));
        jsonO = (JSONObject) mainObj.get("featuredPrice");
        JSONObject json1 = (JSONObject) jsonO.get("currentPrice");

        String priceMin = String.valueOf(json1.get("formatted"));

        List<String> roomType = new ArrayList<>();
        JSONArray arr = (JSONArray) mainObj.get("roomTypeNames");
        for(int i =0;i < arr.size();i++) {
            roomType.add(String.valueOf(arr.get(i)));
        }

        jsonO = (JSONObject) jsonObject1.get("guestReviews");
        json1 = (JSONObject) jsonO.get("brands");
        float averagePeopleReit = Float.parseFloat(String.valueOf(json1.get("rating")));
        int numPeople = Integer.parseInt(String.valueOf(json1.get("total")));

        mainObj = (JSONObject) jsonObject1.get("specialFeatures");
        List<String> feature = new ArrayList<>();
        JSONArray arrJ = (JSONArray) mainObj.get("sections");
        for(int k = 0; k <arrJ.size();k++){
            JSONObject jj = (JSONObject) arrJ.get(k);
            feature.add(String.valueOf(jj.get("heading")));
        }


        jsonObject1 = (JSONObject) jsonObject.get("transportation");
        arr = (JSONArray) jsonObject1.get("transportLocations");
        List<Transport> trasnport =new ArrayList<>();
        for(int i = 0; i <arr.size();i++){
            JSONObject js = (JSONObject) arr.get(i);
            String transportCategory = String.valueOf(js.get("category"));

            JSONArray ja = (JSONArray) js.get("locations");
            List<String> locations = new ArrayList<>();
            for(int j = 0;j < ja.size();j++){
                JSONObject jjo = (JSONObject) ja.get(j);
                locations.add(String.valueOf(jjo.get("name")));
            }
            trasnport.add(new Transport(transportCategory,locations));
        }

        Hotel hotelinfo = new Hotel(titleHotel,ratingHotel,address,id,priceMin,roomType,feature,
        trasnport,averagePeopleReit,numPeople);
        return hotelinfo;

    }

    /**
     *  Method for getting the hotel ID.
     *  Parses the response to JSONObject and returns json array list containing hotel objects.
      * @param title name of the city
     * @return listHotelMain a list containing json array's
     * @throws Exception a RuntimeException
     */
   public static List<Hotel> getHotelID(String title) throws Exception {
        getLatitude(title);
        JSONParser parse = new JSONParser();

        JSONObject jsonObject = (JSONObject)parse.parse(response);
        JSONObject jsonarr_1 = (JSONObject) jsonObject.get("data");
        JSONObject jsonarr_2 = (JSONObject) jsonarr_1.get("body");
        JSONObject jsonarr_3 = (JSONObject) jsonarr_2.get("searchResults");
        JSONArray jsonarr = (JSONArray) jsonarr_3.get("results");
        listHotelMain = getHotelAll(jsonarr);

        return listHotelMain;
    }


    /**
     * Method for getting all the hotels from the API.
     * Gets address, name, star rating and id from the given json array
     *
     * @param jsonArr array containing hotel objects.
     * @return hotelList list containing Hotel objects
     * @throws Exception a runtimeException
     */
    public static List<Hotel> getHotelAll(JSONArray jsonArr) throws Exception{
        List<Hotel> hotelList = new ArrayList<>();

        for(int i = 0; i < jsonArr.size(); i++){
            JSONObject mainJ = (JSONObject) jsonArr.get(i);
            JSONObject loc = (JSONObject) mainJ.get("address");
            hotelList.add(new Hotel(String.valueOf(mainJ.get("name")),Float.parseFloat(String.valueOf(mainJ.get("starRating")))
                    ,String.valueOf(loc.get("streetAddress")),Integer.parseInt(String.valueOf(mainJ.get("id")))));
        }
        return hotelList;
    }

    /**
     * Method for getting nearby attractions of the specified city from InfoAPI class.
     * Parses the response from the api to JSONObject and returns a string containing
     * information about nearby attractions.
     * @param countryTitle name of the city
     * @return stringList list containing information about nearby attractions
     * @throws Exception a runtimeException
     */
    public static List<attraction> getSuggesionRep(String countryTitle) throws Exception{
        JSONParser parse = new JSONParser();
        List<attraction> stringList = new ArrayList<>();
        JSONObject jsonObject = (JSONObject)parse.parse(InfoAPI.getEntityInfo(countryTitle));
        JSONArray arr = (JSONArray) jsonObject.get("suggestions");
        JSONObject jsonObject_find = null;
        for(int i = 0; i < arr.size();i++){
            JSONObject json = (JSONObject) arr.get(i);
            if(String.valueOf(json.get("group")).equals("LANDMARK_GROUP")){
                jsonObject_find = json;
                break;
            }
        }
        arr = (JSONArray) jsonObject_find.get("entities");
        for(int i = 0;i < arr.size();i++){
            JSONObject json = (JSONObject) arr.get(i);
            stringList.add(new attraction(String.valueOf(json.get("name"))));
        }

        return stringList;
    }

    /**
     * Method for getting comments and rating about the hotel from HotelAPI class specified by its id.
     * Parses the response from the api to JSONObject and returns a list containing comments and reviews about
     * a specific hotel.
     * @param id identification of the hotel
     * @return reitingList a list containing all the comments and ratings of a specific hotel
     * @throws IOException Signals that an I/O exception of some sort has occurred.
     * @throws ParseException Signals that an error has been reached unexpectedly while parsing.
     */
    public static List<reiting> getListReiting(int id) throws IOException, ParseException {
        JSONParser parse = new JSONParser();
        List<reiting> reitingList = new ArrayList<>();
        JSONObject jsonObject = (JSONObject) parse.parse(HotelAPI.getReveiw(id));
        JSONObject jsonObject1 = (JSONObject) jsonObject.get("reviewData");
        JSONObject jsonObject2 = (JSONObject) jsonObject1.get("guestReviewGroups");
        JSONArray arrJson = (JSONArray) jsonObject2.get("guestReviews");
       JSONObject jsonArr = (JSONObject) arrJson.get(0);
       JSONArray arrMAin = (JSONArray) jsonArr.get("reviews");
       for(int i = 0; i < arrMAin.size();i++){
           JSONObject js = (JSONObject) arrMAin.get(i);
           reitingList.add(new reiting(String.valueOf(js.get("summary")),String.valueOf(js.get("title")),Float.parseFloat(String.valueOf(js.get("formattedRating"))),
                   String.valueOf(js.get("qualitativeBadgeText"))));
       }
       return reitingList;
       }
}
