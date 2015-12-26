package com.example.eli.newstest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Eli on 22/12/2015.
 */
public class ListAdapter extends ArrayAdapter<ItemNews> {

    private final Context context;
    private ArrayList<ItemNews> itemsArrayList;

    public ListAdapter(Context context, ArrayList<ItemNews> itemsArrayList){
        super(context,R.layout.row_news,itemsArrayList);
        this.context = context;
        this.itemsArrayList=itemsArrayList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row_news, parent, false);

        ItemNews currentItem = getItem(position);

        TextView tvFormule = (TextView) rowView.findViewById(R.id.tv_formule);
        TextView tvUrl = (TextView) rowView.findViewById(R.id.tv_url);



        tvFormule.setText(currentItem.getFormule());
        tvUrl.setText(currentItem.getUrl());



        return rowView;
    }
}
