package lt.viko.eif.generatoriai.demo.api;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class InfoAPI {

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
