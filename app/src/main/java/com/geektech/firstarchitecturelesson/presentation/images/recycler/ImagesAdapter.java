package com.geektech.firstarchitecturelesson.presentation.images.recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.geektech.firstarchitecturelesson.R;
import com.geektech.firstarchitecturelesson.presentation.images.model.ImageEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by askar on 1/18/19
 * with Android Studio
 */
public class ImagesAdapter extends RecyclerView.Adapter {

    private ArrayList<ImageEntity> mImages = new ArrayList<>();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ImageViewHolder(
                LayoutInflater.from(viewGroup.getContext())
                        .inflate(
                                R.layout.adapter_image_item,
                                viewGroup,
                                false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof ImageViewHolder) {
            ((ImageViewHolder) viewHolder).onBind(mImages.get(i));
        }
    }

    @Override
    public int getItemCount() {
        return mImages.size();
    }

    public void setImages(List<ImageEntity> images){
        mImages.clear();
        mImages.addAll(images);
        notifyDataSetChanged();
    }
}
