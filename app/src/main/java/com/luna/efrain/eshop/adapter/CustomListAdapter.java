package com.luna.efrain.eshop.adapter;

/**
 * Created by Efraín on 2015-05-14.
 */

import com.luna.efrain.eshop.R;
import com.luna.efrain.eshop.app.AppController;
import com.luna.efrain.eshop.model.Ad;
import com.luna.efrain.eshop.model.Movie;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Movie> movieItems;
    private List<Ad> adItems;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public CustomListAdapter(Activity activity, List<Movie> movieItems) {
        this.activity = activity;
        this.movieItems = movieItems;
    }

    @Override
    public int getCount() {
        return movieItems.size();
    }

    @Override
    public Object getItem(int location) {
        return movieItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_row, null);

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();
        NetworkImageView thumbNail = (NetworkImageView) convertView
                .findViewById(R.id.ad_stringThumbnail);
        TextView name = (TextView) convertView.findViewById(R.id.ad_name);
        TextView views = (TextView) convertView.findViewById(R.id.ad_views);

        // getting movie data for the row
        Ad a = adItems.get(position);

        // thumbnail image
        thumbNail.setImageUrl(a.getStringThumbnail(), imageLoader);

        // title
        name.setText(a.getName());

        // rating
        views.setText("Rating: " + String.valueOf(a.getViews()));


        return convertView;
    }

}
