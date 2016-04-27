package pl.govirtual.stylizacja24;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by User on 27.04.16.
 */
public class Stylizacja24Connector {

    private static Stylizacja24API stylizacja24ApiInterface ;
    private static String baseUrl = "http://stylizacja24.pl" ;

    Retrofit client = new Retrofit.Builder()
            .baseUrl(baseUrl)
            .build();

    public static Stylizacja24API getClient() {
        if (stylizacja24ApiInterface == null) {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            stylizacja24ApiInterface = retrofit.create(Stylizacja24API.class);

        }
        return stylizacja24ApiInterface ;
    }


}
