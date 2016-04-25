package pl.govirtual.stylizacja24;

import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by User on 25.04.16.
 */
public interface Stylizacja24API {
    //You can use rx.java for sophisticated composition of requests
    @GET("/users/{user}")
    public Observable<SomeUserModel> fetchUser(@Path("user") String user);

    //or you can just get your model if you use json api
    @GET("/users/{user}")
    public SomeUserModel fetchUser(@Path("user") String user);

    //or if there are some special cases you can process your response manually
    @GET("/users/{user}")
    public Response fetchUser(@Path("user") String user);
}
