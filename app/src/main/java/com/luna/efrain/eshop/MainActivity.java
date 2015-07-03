package com.luna.efrain.eshop;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.luna.efrain.eshop.adapter.CustomListAdapter;
import com.luna.efrain.eshop.app.AppController;
import com.luna.efrain.eshop.model.Ad;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements LocationListener {
    // Log tag
    private static final String TAG = MainActivity.class.getSimpleName();

    // Movies json url
    private static String url = "http://172./eshopRest/listAds";
    private ProgressDialog pDialog;
    private List<Ad> adList = new ArrayList<Ad>();
    private ListView listView;
    private CustomListAdapter adapter;
    protected LocationManager locationManager;
    protected LocationListener locationListener;
    protected double latitude,longitude=-999.99;
    protected boolean gps_enabled,network_enabled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //To get coordinates

            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);


        //For the listview
        listView = (ListView) findViewById(R.id.list);
        //adapter = new CustomListAdapter(this, adList);
        listView.setAdapter(adapter);

        pDialog = new ProgressDialog(this);
        // Showing progress dialog before making http request
        pDialog.setMessage("Loading...");
        pDialog.show();

        // changing action bar color
        //getActionBar().setBackgroundDrawable(
         //       new ColorDrawable(Color.parseColor("#1b1b1b")));

        // Creating volley request obj
        if((longitude != -999.99) && (latitude != -999.99))
            url+= "?longi=" + String.valueOf(longitude) + "&lati=" + String.valueOf(latitude);


        JsonArrayRequest adReq = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        hidePDialog();

                        // Parsing json
                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject obj = response.getJSONObject(i);
                                Ad ad = new Ad();
                                ad.setId(obj.getInt("id"));
                                ad.setStringThumbnail(obj.getString("stringThumbnail"));
                                ad.setStringImage(obj.getString("stringImage"));
                                ad.setName(obj.getString("name"));
                                ad.setDescription(obj.getString("description"));
                                ad.setCost(obj.getDouble("cost"));
                                ad.setStatus(obj.getString("status"));
                                //ad.setPostingDate(obj.getString("postingDate"));
                                ad.setViews(obj.getInt("views"));
                                ad.setLati(obj.getDouble("lati"));
                                ad.setLongi(obj.getDouble("longi"));
                                //ad.setIdUser(obj.getJSONObject("user"));

                               /*
                                // Genre is json array
                                JSONArray genreArry = obj.getJSONArray("genre");
                                ArrayList<String> genre = new ArrayList<String>();
                                for (int j = 0; j < genreArry.length(); j++) {
                                    genre.add((String) genreArry.get(j));
                                }
                                movie.setGenre(genre);

                                // adding movie to movies array
                                movieList.add(movie);*/

                                adList.add(ad);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }

                        // notifying list adapter about data changes
                        // so that it renders the list view with updated data
                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                hidePDialog();

            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(adReq);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        hidePDialog();
    }

    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    //Getting location associated functions
    @Override
    public void onLocationChanged(Location location) {
        try {
            longitude = location.getLongitude();
            latitude = location.getLatitude();
        }catch(NullPointerException e){
        e.printStackTrace();
        return;
    }catch(Exception e){
        e.printStackTrace();
        return;
    }
        //TextView txtLongitude = (TextView)findViewById(R.id.txtLongitude);
        //TextView txtLatitude = (TextView)findViewById(R.id.txtLatitude);
       // txtLongitude.setText(String.valueOf(location.getLongitude()));
       // txtLatitude.setText(String.valueOf(location.getLatitude()));
    }

    @Override
    public void onProviderDisabled(String provider) {
        Log.d("Latitude", "disable");
    }

    @Override
    public void onProviderEnabled(String provider) {
        Log.d("Latitude","enable");
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        Log.d("Latitude", "status");
    }


}
