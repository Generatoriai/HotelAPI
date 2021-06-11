package lt.viko.eif.generatoriai.demo.api;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 *  API that is used to get hotels in a city based on it's coordinates.
 */
public class HotelAPI {

    /**
     *  Getting hotels in a city.
     *
     * @param lng longitude in double type
     * @param lat latitude in double type
     * @return responseString in String type
     * @throws IOException - this exception exception occurs when invalid input or invalid output has occurred.
     */
    public static String getHotel(double lng, double lat) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://hotels-com-free.p.rapidapi.com/srle/listing/v1/brands/hotels.com?lat=" + lng + "&lon=" + lat + "&checkIn=2021-01-27&checkOut=2021-01-28&rooms=1&locale=en_US&currency=USD&pageNumber=1")
                .get()
                .addHeader("x-rapidapi-key", "37b63ccbf7mshcd66e21c580e21ep1a328djsndacc86e2bdbd")
                .addHeader("x-rapidapi-host", "hotels-com-free.p.rapidapi.com")
                .build();

        Response response = client.newCall(request).execute();

        String responseString = response.body().string();
        return responseString;
    }

    public static String getReveiw(int id)throws IOException{
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://hotels-com-free.p.rapidapi.com/mobile_service/property-content/v1/hotels.com/property/" + id + "/reviews?loc=en_US&page=1")
                .get()
                .addHeader("x-rapidapi-key", "37b63ccbf7mshcd66e21c580e21ep1a328djsndacc86e2bdbd")
                .addHeader("x-rapidapi-host", "hotels-com-free.p.rapidapi.com")
                .build();

        Response response = client.newCall(request).execute();
        String responseString = response.body().string();
        return responseString;
    }
}
