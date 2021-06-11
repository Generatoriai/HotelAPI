package lt.viko.eif.generatoriai.demo.api;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 *  API that is used to get coordinates of a named city.
 */
public class CoordinatesAPI {

    /**
     *  Getting coordinates of needed city.
     *
     * @param city
     * @return
     * @throws IOException
     */
    public static String getResponse(String city) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://trueway-geocoding.p.rapidapi.com/Geocode?address="+city+"&language=en")
                .get()
                .addHeader("x-rapidapi-key", "7046fba1famsh57fe237a4f80d4bp1eb80cjsn05ddf0d7b757")
                .addHeader("x-rapidapi-host", "trueway-geocoding.p.rapidapi.com")
                .build();

        Response response = client.newCall(request).execute();

        String responseString = response.body().string();

        return responseString;
    }

}
