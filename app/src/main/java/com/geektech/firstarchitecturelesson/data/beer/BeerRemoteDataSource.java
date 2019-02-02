package com.geektech.firstarchitecturelesson.data.beer;

import com.geektech.core.BaseCallback;
import com.geektech.firstarchitecturelesson.data.beer.model.Beer;
import com.geektech.firstarchitecturelesson.data.beer.remote.BeerNetworkClient;
import com.geektech.firstarchitecturelesson.data.beer.remote.BeerRemoteConfig;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by askar on 1/26/19
 * with Android Studio
 */
public class BeerRemoteDataSource {
    static Retrofit getRetrofit(String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private BeerNetworkClient mClient;

    public BeerRemoteDataSource() {
        mClient = getRetrofit(BeerRemoteConfig.BASE_URL)
                .create(BeerNetworkClient.class);
    }

    public void getBeerList(int page, int perPage, BeerListCallback callback) {
        Call<List<Beer>> call = mClient.getBeerList(page, perPage);

        call.enqueue(new Callback<List<Beer>>() {
            @Override
            public void onResponse(Call<List<Beer>> call, Response<List<Beer>> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        callback.onSuccess(response.body());
                    } else {
                        callback.onFail("Body is empty!");
                    }
                } else {

                }
            }

            @Override
            public void onFailure(Call<List<Beer>> call, Throwable t) {
                callback.onFail(t.getMessage());
            }
        });
    }

    public void getBeer(int id, BeerCallback callback) {
        Call<List<Beer>> call = mClient.getBeer(id);

        call.enqueue(new Callback<List<Beer>>() {
            @Override
            public void onResponse(Call<List<Beer>> call, Response<List<Beer>> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        callback.onSuccess(response.body().get(0));
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Beer>> call, Throwable t) {
                callback.onFail(t.getMessage());
            }
        });
    }

    public interface BeerListCallback extends BaseCallback<List<Beer>>{}
    public interface BeerCallback extends BaseCallback<Beer>{}
}
