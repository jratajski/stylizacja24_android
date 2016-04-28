package pl.govirtual.stylizacja24;

import java.util.List;

import pl.govirtual.stylizacja24.POJO.ImageResponse;
import pl.govirtual.stylizacja24.POJO.LoginResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Jakub Ratajski on 25.04.16.
 */
public interface Stylizacja24API {

    @FormUrlEncoded
    @POST("/api/v1/login")
    public Call<LoginResponse> loginUser(@Field("login") String login, @Field("password") String password);

    @FormUrlEncoded
    @POST("/api/v1/register")
    public Call<LoginResponse> registerUser(@Field("login") String name, @Field("email") String email, @Field("password") String password, @Field("sex") Character sex, @Field("age") int age, @Field("district") int district, @Field("preferred_size") int preferred_size);

    @GET("/api/v1/przymierzalnia/list")
    public Call<ImageResponse> getDressingList();
}
