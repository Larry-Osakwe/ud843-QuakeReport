package com.example.android.quakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Larry Osakwe on 6/13/2017.
 */

public class QuakeAdapter extends ArrayAdapter<Quake> {
    public QuakeAdapter(Context context, ArrayList<Quake> quakes) {
        super(context, 0);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Quake currentQuake = getItem(position);

        TextView magnitude = (TextView) listItemView.findViewById(R.id.magnitude);
        magnitude.setText((currentQuake.getMagnitude()));

        TextView location = (TextView) listItemView.findViewById(R.id.location);
        location.setText((currentQuake.getLocation()));

        TextView date = (TextView) listItemView.findViewById(R.id.date);
        date.setText((currentQuake.getDate()));


        return listItemView;


    }
}
