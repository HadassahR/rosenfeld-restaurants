package rosenfeld.restaurants;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * creates open weather source classes using Retrofit
 */
public class DocumenuFactory {

    public DocumenuService newInstance() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.documenu.com/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();

        DocumenuService service = retrofit.create(DocumenuService.class);

        return service;
    }
}