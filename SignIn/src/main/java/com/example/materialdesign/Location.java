package com.example.materialdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;

public class Location extends AppCompatActivity {
    Button Button;
    EditText latitude, longitude;
    String locationText = "";
    String locationLatitude = "";
    String locationLongitude = "";
    AlertDialog alertDialog2;
    private int mInterval = 3000;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        latitude = (EditText) findViewById(R.id.yourLatitude);
        latitude = (EditText) findViewById(R.id.yourLongitude);
        Button = (Button) findViewById(R.id.button);

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Location.this);

        alertDialog2.setTitle("Notification");
        String string1 = "give it 10-15 seconds for your coordinates to update";

        alertDialog2.setMessage(string1);
        alertDialog2.setIcon(R.drawable.ic_launcher_background);
        // alertDialog2.setPositiveButton("");
    }
}