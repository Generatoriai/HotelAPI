package lt.viko.eif.generatoriai.demo.api;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/***
 *  API that is used to get information on hotels and cities.
 */
public class InfoAPI {

    /***
     *  Getting needed information about hotel.
     *
     * @param id - id in Integer type
     * @return responseString in String type
     * @throws IOException - this exception exception occurs when invalid input or invalid output has occurred.
     */
    public static String getHotelInfo(int id) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://hotels4.p.rapidapi.com/properties/get-details?id="+id+"&checkIn=2020-01-08&checkOut=2020-01-15&currency=USD&locale=en_US&adults1=1")
                .get()
                .addHeader("x-rapidapi-key", "7046fba1famsh57fe237a4f80d4bp1eb80cjsn05ddf0d7b757")
                .addHeader("x-rapidapi-host", "hotels4.p.rapidapi.com")
                .build();

        Response response = client.newCall(request).execute();

        String responseString = response.body().string();
        return responseString;
    }

    /**
     *  Getting places to visit in a city.
     *
     * @param countryTitle
     * @return
     * @throws IOException
     */
    public static String getEntityInfo(String countryTitle) throws IOException{
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://hotels4.p.rapidapi.com/locations/search?query=" + countryTitle + "&locale=en_US")
                .get()
                .addHeader("x-rapidapi-key", "37b63ccbf7mshcd66e21c580e21ep1a328djsndacc86e2bdbd")
                .addHeader("x-rapidapi-host", "hotels4.p.rapidapi.com")
                .build();

        Response response = client.newCall(request).execute();
        String responseString = response.body().string();
        return responseString;
    }
}
