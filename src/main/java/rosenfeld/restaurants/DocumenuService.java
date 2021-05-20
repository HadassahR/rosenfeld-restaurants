package rosenfeld.restaurants;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

import javax.print.DocFlavor;

public interface DocumenuService {

    @GET("https://api.documenu.com/v2/restaurants/search/geo?key=24c01e0c64548704a193ce74c25e52ce")
    Single<DocumenuFeed> getByZipCode(
            @Query("lat") String latitude,
            @Query("lon") String longitude,
            @Query("distance") String miles,
            @Query("cuisine") String cuisine,
            @Query("size") String size
    );

}
