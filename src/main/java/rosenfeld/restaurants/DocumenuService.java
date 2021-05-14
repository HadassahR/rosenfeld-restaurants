package rosenfeld.restaurants;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DocumenuService {

    @GET("https://api.documenu.xyz/v2/restaurants/zipcode?APPID=24c01e0c64548704a193ce74c25e52ce")
    Single<DocumenuFeed> getByZipCode(
            @Query("zip") String zipCode
    );

}
