package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
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


        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitude.getBackground();
        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());
        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);


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

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }


}





