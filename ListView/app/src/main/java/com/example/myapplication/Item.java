package com.example.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class Item extends CustomBaseAdapter {
    String[] gia;
    public Item(Context ctx, String[] listFood, int[] images, String[] gia) {
        super(ctx,  listFood, images);
        this.gia = gia;
    }

    @Override
    public boolean canClickItem() {
        return false;
    }

    public View getView(int i, View convertView, ViewGroup parent) {
        convertView =  inflater.inflate(R.layout.activity_custom_list_view, null);
        TextView nameTextView = (TextView) convertView.findViewById(R.id.textView);
        TextView desTextView = (TextView) convertView.findViewById(R.id.textView2);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);
        nameTextView.setText (listDish[i]);
        desTextView.setText("Giá: " + gia[i]);
        imageView.setImageResource(listImages[i]);
        return convertView;
    }
}

