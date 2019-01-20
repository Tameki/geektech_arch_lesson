package com.geektech.firstarchitecturelesson.presentation.images.recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.geektech.firstarchitecturelesson.R;
import com.geektech.firstarchitecturelesson.presentation.images.model.ImageEntity;

/**
 * Created by askar on 1/18/19
 * with Android Studio
 */
public class ImageViewHolder extends RecyclerView.ViewHolder {

    private ImageView mImage;

    public ImageViewHolder(@NonNull View itemView) {
        super(itemView);
        mImage = itemView.findViewById(R.id.adapter_image_view);
    }

    public void onBind(ImageEntity image) {
        Glide.with(itemView.getContext())
                .load(image.getUrl())
                .into(mImage);
    }
}
