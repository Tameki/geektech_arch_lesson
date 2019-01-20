package com.geektech.firstarchitecturelesson.presentation.images;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geektech.firstarchitecturelesson.R;
import com.geektech.firstarchitecturelesson.presentation.images.model.ImageEntity;
import com.geektech.firstarchitecturelesson.presentation.images.recycler.ImagesAdapter;

import java.util.ArrayList;

/**
 * Created by askar on 1/18/19
 * with Android Studio
 */
public class ImagesFragment extends Fragment {

    private RecyclerView mRecycler;
    private ImagesAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.fragment_images,
                container,
                false);

        init(rootView);

        return rootView;
    }

    private void init(View rootView) {
        mAdapter = new ImagesAdapter();
        mRecycler = rootView.findViewById(R.id.fragment_images_recycler);

        mRecycler.setLayoutManager(
                new LinearLayoutManager(
                        getContext(),
                        RecyclerView.VERTICAL,
                        false)
        );
        mRecycler.setAdapter(mAdapter);

        loadData();
    }

    private void loadData(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ArrayList<ImageEntity> images = new ArrayList<>();
                images.add(new ImageEntity("https://media.gettyimages.com/photos/hong-kong-looking-up-from-the-patio-of-a-public-apartment-building-picture-id684148186"));
                images.add(new ImageEntity("https://media.gettyimages.com/photos/hong-kong-looking-up-from-the-patio-of-a-public-apartment-building-picture-id684148186"));
                images.add(new ImageEntity("https://media.gettyimages.com/photos/hong-kong-looking-up-from-the-patio-of-a-public-apartment-building-picture-id684148186"));

                mAdapter.setImages(images);
            }
        }, 2000);
    }
}
