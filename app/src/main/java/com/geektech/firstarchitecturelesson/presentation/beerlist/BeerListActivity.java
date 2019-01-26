package com.geektech.firstarchitecturelesson.presentation.beerlist;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.geektech.firstarchitecturelesson.data.beer.BeerRemoteDataSource;
import com.geektech.firstarchitecturelesson.data.beer.model.Beer;

import java.util.List;

/**
 * Created by askar on 1/26/19
 * with Android Studio
 */
public class BeerListActivity extends AppCompatActivity {

    private BeerRemoteDataSource mBeerSource;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBeerSource = new BeerRemoteDataSource();
    }

    @Override
    protected void onResume() {
        super.onResume();

//        mBeerSource.getBeerList(2, 20, new BeerRemoteDataSource.BeerListCallback() {
//            @Override
//            public void onSuccess(List<Beer> result) {
//                for (Beer beer : result) {
//                    Log.d("ololo", beer.toString());
//                }
//            }
//
//            @Override
//            public void onFail(String message) {
//
//            }
//        });

        mBeerSource.getBeer(1, new BeerRemoteDataSource.BeerCallback() {
            @Override
            public void onSuccess(Beer result) {
                Log.d("ololo", "Single\n" + result);
            }

            @Override
            public void onFail(String message) {
                Log.d("ololo", message);
            }
        });
    }
}
