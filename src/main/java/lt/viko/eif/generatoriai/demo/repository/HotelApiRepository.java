package lt.viko.eif.generatoriai.demo.repository;

import lt.viko.eif.generatoriai.demo.api.CoordinatesAPI;
import lt.viko.eif.generatoriai.demo.api.HotelAPI;
import lt.viko.eif.generatoriai.demo.api.InfoAPI;
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

    static void getInfo(int id) throws IOException, ParseException {
        //info hotel one
        JSONParser parse = new JSONParser();
        JSONObject jsonObject = (JSONObject)parse.parse(InfoAPI.getHotelInfo(id));

        System.out.println(InfoAPI.getHotelInfo(id));

//        JSONArray jsonarr_1 = (JSONArray) jsonObject.get("result");
//        for(int i=0; i<jsonarr_1.size();i++){
//            System.out.println(jsonarr_1.get(i));
//        }
    }

    static void getHotelID() throws Exception {
        JSONParser parse = new JSONParser();
        //grazint visus id, ir isrenkam info


        JSONObject jsonObject = (JSONObject)parse.parse(response);
        JSONObject jsonarr_1 = (JSONObject) jsonObject.get("data");
        JSONObject jsonarr_2 = (JSONObject) jsonarr_1.get("body");
        JSONObject jsonarr_3 = (JSONObject) jsonarr_2.get("searchResults");
        JSONArray jsonarr = (JSONArray) jsonarr_3.get("results");
        listHotelMain = getHotelAll(jsonarr);

        for(hotel h :listHotelMain){
            //pakeist i visa info
            System.out.println(h.getTitle());
        }
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
