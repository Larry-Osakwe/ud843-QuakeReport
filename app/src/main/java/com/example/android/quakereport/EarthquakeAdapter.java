package com.example.android.quakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
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
        //formats all magnitudes to one decimal place


        currentEarthquake = getItem(position);

        //Set value for magnitude
        TextView magnitude = (TextView) listItemView.findViewById(R.id.magnitude);
        magnitude.setText(formatMagnitude(currentEarthquake.getMagnitude()));

        //Set value for location offset ex 'near'
        TextView locationOffset = (TextView) listItemView.findViewById(R.id.location_offset);
        locationOffset.setText(locationOffset(currentEarthquake.getLocation()));

        //Set value for location
        TextView location = (TextView) listItemView.findViewById(R.id.location);
        location.setText(locationOfInterest(currentEarthquake.getLocation()));

        //Set value for date mmm dd, yyyy
        TextView date = (TextView) listItemView.findViewById(R.id.date);
        date.setText(dateFormat());

        //Set value for time h:mm a
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

    public String locationOffset(String location) {

        if (location.contains("of")) {
            String[] parts = location.split("(?<=of)");
            String part1 = parts[0];
            return part1;
        }
        return "Near the";
    }

    public String locationOfInterest(String location) {
        if (location.contains("of")) {
            String[] parts = location.split("(?<=of )");
            String part1 = parts[1];
            return part1;
        }
        return location;

    }

    public String formatMagnitude(double magnitude) {
        DecimalFormat formatter = new DecimalFormat("0.0");
        return formatter.format(magnitude);
    }




}
