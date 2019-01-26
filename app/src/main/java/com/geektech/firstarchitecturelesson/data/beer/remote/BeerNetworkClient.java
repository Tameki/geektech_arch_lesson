package com.geektech.firstarchitecturelesson.data.beer.remote;

import com.geektech.firstarchitecturelesson.data.beer.model.Beer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by askar on 1/26/19
 * with Android Studio
 */
public interface BeerNetworkClient {
    @GET(BeerRemoteConfig.BEER_LIST)
    Call<List<Beer>> getBeerList (
            @Query("page") int page,
            @Query("per_page") int per_page
    );

    @GET(BeerRemoteConfig.BEER)
    Call<List<Beer>> getBeer (@Path("id") int id);

}
