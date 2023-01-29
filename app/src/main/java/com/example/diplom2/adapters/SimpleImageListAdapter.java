package com.example.diplom2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.diplom2.R;

import java.util.List;


public class SimpleImageListAdapter extends ArrayAdapter {
    private String[] imageUrl;
    private Context context;
    private LayoutInflater inflater;

    public SimpleImageListAdapter(Context context, String[] imageUrl) {
        super(context, R.layout.image_item, imageUrl);

        this.context = context;
        this.imageUrl = imageUrl;

        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (null == convertView) {
            convertView = inflater.inflate(R.layout.image_item, parent, false);
        }
        Glide
                .with(context)
                .load(imageUrl[position])
                .into((ImageView) convertView);

        return convertView;
    }
}
