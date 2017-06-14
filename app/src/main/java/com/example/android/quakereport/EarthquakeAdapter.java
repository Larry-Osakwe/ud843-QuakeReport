package com.example.android.quakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Larry Osakwe on 6/13/2017.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private Earthquake currentEarthquake;

    public EarthquakeAdapter(Context context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        currentEarthquake = getItem(position);

        TextView magnitude = (TextView) listItemView.findViewById(R.id.magnitude);
        magnitude.setText(currentEarthquake.getMagnitude() + "");

        TextView location = (TextView) listItemView.findViewById(R.id.location);
        location.setText(currentEarthquake.getLocation());

        TextView date = (TextView) listItemView.findViewById(R.id.date);
        date.setText(dateFormat());

        TextView time = (TextView) listItemView.findViewById(R.id.time);
        time.setText(timeFormat());


        return listItemView;


    }

    public String dateFormat() {
        long timeInMilliseconds = currentEarthquake.getDate();
        Date dateObject = new Date(timeInMilliseconds);
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, yyyy");

        return dateFormatter.format(dateObject);
    }

    public String timeFormat() {
        long timeInMilliseconds = currentEarthquake.getDate();
        Date timeObject = new Date(timeInMilliseconds);
        SimpleDateFormat dateFormatter = new SimpleDateFormat("h:mm a");

        return dateFormatter.format(timeObject);
    }


}
