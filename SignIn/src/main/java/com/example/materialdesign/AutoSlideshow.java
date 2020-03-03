package com.example.materialdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class AutoSlideshow extends AppCompatActivity {

    ViewFlipper v_flipper;
    Button bt, Submit;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_slideshow);

        int image[] ={R.drawable.garbagelorry,R.drawable.garbagelorry,R.drawable.garbage5,R.drawable.garbage2,R.drawable.waste1};
        v_flipper= (ViewFlipper)findViewById(R.id.myflipper);

        for (int i = 0; i< image.length; i++){

        flipperImages(image[i]);
                }
                for (int images:image){

                }
        Submit=(Button)findViewById(R.id.button);
        spinner=(Spinner)findViewById(R.id.spinner);
        final ArrayList<String> Interval= new ArrayList<>();
        Interval.add("Click Here");
        Interval.add("Twise a week");
        Interval.add("Weekly basis");
        Interval.add("After 2 weeks");
        Interval.add("Monthly");

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,Interval);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(AutoSlideshow.this, Interval.get(position), Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(getApplicationContext(),Register.class);
                startActivity(intent);
            }
        });
    }
    public void flipperImages(int image) {
        ImageView imageView;
        imageView = new ImageView(this);
        imageView.setBackgroundResource(image);
        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(6000);
        v_flipper.setAutoStart(true);
        v_flipper.setInAnimation(this,android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this,android.R.anim.slide_out_right);



    }


}
