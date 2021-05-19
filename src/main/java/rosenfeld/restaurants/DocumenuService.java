package rosenfeld.restaurants;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DocumenuService {

    @GET("https://api.documenu.com/v2/restaurants/search/fields?key=24c01e0c64548704a193ce74c25e52ce")
    Single<DocumenuFeed> getByZipCode(
            @Query("zip_code") String zip,
            @Query("cuisine") String cuisine
    );

}
