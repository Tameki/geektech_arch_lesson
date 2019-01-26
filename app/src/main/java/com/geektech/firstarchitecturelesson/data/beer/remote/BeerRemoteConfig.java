package com.geektech.firstarchitecturelesson.data.beer.remote;

/**
 * Created by askar on 1/26/19
 * with Android Studio
 */
public class BeerRemoteConfig {
    public static final String BASE_URL = "https://api.punkapi.com";
    private static final String API_VERSION = "/v2";
    public static final String BEER_LIST = API_VERSION + "/beers";
    public static final String BEER = BEER_LIST + "/{id}";
}
