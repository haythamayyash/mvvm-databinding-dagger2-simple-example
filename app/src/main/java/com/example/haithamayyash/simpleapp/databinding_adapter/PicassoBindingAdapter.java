package com.example.haithamayyash.simpleapp.databinding_adapter;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import androidx.databinding.BindingAdapter;

public class PicassoBindingAdapter {
    @BindingAdapter("imageResourse")
    public static void setImageResource(ImageView view , String res){
        Picasso.get().load(res).into(view);
    }
}
