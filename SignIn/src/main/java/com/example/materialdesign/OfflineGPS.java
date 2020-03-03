package com.example.materialdesign;
import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;

public class OfflineGPS extends AppCompatActivity implements LocationListener {
    Button Button;
    EditText latitude,longitude,phone;
    LocationManager locationManager;
    String locationText = "";
    String locationLatitude = "";
    String locationLongitude = "";
    private int mInterval = 3000; // 3 seconds by default, can be changed later
    private Handler mHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps_offline);
        phone=(EditText)findViewById(R.id.phone);
        latitude=(EditText)findViewById(R.id.yourLatitude);
        longitude=(EditText)findViewById(R.id.yourLongitude);
        Button=(Button) findViewById(R.id.button);

        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(OfflineGPS.this, "sending data", Toast.LENGTH_LONG).show();
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                String url="http://www.olande.co.ke/coordinates.php?phone="+phone.getText().toString()+"&yourLongitude="+longitude.getText().toString()+"&yourLatitude="+latitude.getText();
                JsonObjectRequest jsonObjectRequest= new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(OfflineGPS.this, "response", Toast.LENGTH_LONG).show();
                        try {
                            if (response.getString("status").equals("true")){
                                Toast.makeText(OfflineGPS.this, "register success", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(OfflineGPS.this, Signin.class);
                                startActivity(intent);

                            }else {

                                Toast.makeText(OfflineGPS.this, response.getString("message"), Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(OfflineGPS.this, error.getMessage(), Toast.LENGTH_LONG).show();

                    }
                });

                requestQueue.add(jsonObjectRequest);

            }
        });
        //Alert Dialog
        AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(
                OfflineGPS.this);

        // Setting Dialog Title
        alertDialog2.setTitle("Notification");

        // Setting Dialog Message
        String string1 = "Give it 10-15 seconds for your coordinates to update. Keep moving around and you will see coordinates update.";

        alertDialog2.setMessage(string1);

        // Setting Icon to Dialog
        alertDialog2.setIcon(R.drawable.ic_launcher_background);

        // Setting Positive "Yes" Btn
        alertDialog2.setPositiveButton("Continue",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        // Showing Alert Dialog
        alertDialog2.show();

        Handler handler2 = new Handler();
        handler2.postDelayed(new Runnable() {
            public void run() {
                mHandler = new Handler();
                startRepeatingTask();
            }
        }, 5000);   //5 seconds


        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 101);

        }

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        stopRepeatingTask();
    }
    Runnable mStatusChecker = new Runnable() {
        @Override
        public void run() {
            final EditText yourlat = (EditText) findViewById(R.id.yourLatitude);
            final EditText yourlong = (EditText) findViewById(R.id.yourLongitude);

            try {
                getLocation(); //this function can change value of mInterval.

                if (locationText.toString() == "") {
                   // Toast.makeText(getApplicationContext(), "Trying to retrieve coordinates.", Toast.LENGTH_LONG).show();
                }
                else {

                //    yourlat.setText(locationLatitude.toString());
                  //  yourlong.setText(locationLongitude.toString());
                }
            } finally {

                mHandler.postDelayed(mStatusChecker, mInterval);
            }
        }
    };

    void startRepeatingTask() {
        mStatusChecker.run();
    }

    void stopRepeatingTask() {
        mHandler.removeCallbacks(mStatusChecker);
    }

    void getLocation() {
        try {
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 5, (LocationListener) this);
        }
        catch(SecurityException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onLocationChanged(Location location) {

        locationText = location.getLatitude() + "," + location.getLongitude();
        locationLatitude = location.getLatitude() + "";
        locationLongitude = location.getLongitude() + "";
    }

    @Override
    public void onProviderDisabled(String provider) {
        Toast.makeText(OfflineGPS.this, "Please Enable GPS", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }

    @Override
    public void onProviderEnabled(String provider) {

    }


}
