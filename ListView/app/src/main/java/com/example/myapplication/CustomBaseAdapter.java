package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
public class CustomBaseAdapter extends BaseAdapter {
    Context context;
    String listFood[];
    int listImages[];
    LayoutInflater inflater;
    public CustomBaseAdapter(Context ctx, String[] listFood, int[] images) {
        this.context = ctx;
        this.listFood = listFood;
        this.listImages = images;
        inflater = LayoutInflater.from(ctx);
    }
    @Override
    public int getCount() {
        return listFood.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    public boolean canClickItem() {
        return true;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView =  inflater.inflate(R.layout.activity_custom_list_view, null);
        TextView nameTextView = (TextView) convertView.findViewById(R.id.textView);
        ImageView imageView =(ImageView) convertView.findViewById(R.id.imageView);
        nameTextView.setText(listFood[position]);
        imageView.setImageResource(listImages[position]);
        return convertView;
    }

}

