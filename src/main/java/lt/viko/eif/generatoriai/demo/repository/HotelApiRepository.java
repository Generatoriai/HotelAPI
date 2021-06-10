package lt.viko.eif.generatoriai.demo.repository;

import com.fasterxml.jackson.annotation.JsonAlias;
import lt.viko.eif.generatoriai.demo.api.CoordinatesAPI;
import lt.viko.eif.generatoriai.demo.api.HotelAPI;
import lt.viko.eif.generatoriai.demo.api.InfoAPI;
import lt.viko.eif.generatoriai.demo.model.Transport;
import lt.viko.eif.generatoriai.demo.model.hotel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HotelApiRepository {
    private static String response;
    private static List<hotel> listHotelMain;


    static void getLatitude(String titleCountry) throws IOException, ParseException {
        JSONParser parse = new JSONParser();
        JSONObject jsonObject = (JSONObject) parse.parse(CoordinatesAPI.getResponse(titleCountry));

        // System.out.println(CoordinatesAPI.getResponse("Didlaukio g. 63, Vilnius"));

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

    //iraso zmogus id
    public static hotel getInfo(int id) throws IOException, ParseException {
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






        hotel hotelinfo = new hotel(titleHotel,ratingHotel,address,id,priceMin,roomType,feature,
        trasnport,averagePeopleReit,numPeople);
        return hotelinfo;
       // System.out.println(InfoAPI.getHotelInfo(id));

//        JSONArray jsonarr_1 = (JSONArray) jsonObject.get("result");
//        for(int i=0; i<jsonarr_1.size();i++){
//            System.out.println(jsonarr_1.get(i));
//        }
    }

   public static List<hotel> getHotelID(String title) throws Exception {
        getLatitude(title);
        JSONParser parse = new JSONParser();
        //grazint visus id, ir isrenkam info


        JSONObject jsonObject = (JSONObject)parse.parse(response);
        JSONObject jsonarr_1 = (JSONObject) jsonObject.get("data");
        JSONObject jsonarr_2 = (JSONObject) jsonarr_1.get("body");
        JSONObject jsonarr_3 = (JSONObject) jsonarr_2.get("searchResults");
        JSONArray jsonarr = (JSONArray) jsonarr_3.get("results");
        listHotelMain = getHotelAll(jsonarr);
        return listHotelMain;

        //for gaut visus id
//        JSONObject mainOb = (JSONObject) jsonarr.get(0);
//        int id  = Integer.parseInt(String.valueOf(mainOb.get("id")));

//        System.out.println(id);
//        getInfo(id);
//
//        for(int i=0; i<jsonarr_1.size();i++){
//            System.out.println(jsonarr_1.get(i));
//        }
//
//        JSONObject listObject = (JSONObject) jsonarr_1.get(0);
//        JSONObject mainObject = (JSONObject) listObject.get("location");
//
//        System.out.println("Longitude - " + mainObject.get("lng"));
//        System.out.println("Latitude  - " + mainObject.get("lat"));


//        JSONObject jsonObject = (JSONObject) parse.parse(HotelAPI));
//
        // System.out.println(InfoAPI.getHotelInfo(424023));

    }

    public static List<hotel> getHotelAll(JSONArray jsonArr) throws Exception{
        List<hotel> hotelList = new ArrayList<>();

        for(int i = 0; i < jsonArr.size(); i++){
            JSONObject mainJ = (JSONObject) jsonArr.get(i);
            JSONObject loc = (JSONObject) mainJ.get("address");
            hotelList.add(new hotel(String.valueOf(mainJ.get("name")),Float.parseFloat(String.valueOf(mainJ.get("starRating")))
                    ,String.valueOf(loc.get("streetAddress")),Integer.parseInt(String.valueOf(mainJ.get("id")))));
        }
        return hotelList;
    }
}
