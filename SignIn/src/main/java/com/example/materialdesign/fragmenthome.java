package com.example.materialdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class fragmenthome extends AppCompatActivity {

    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragmenthome);
        spinner= (Spinner) findViewById(R.id.spinner);

        final ArrayList<String> Interval= new ArrayList<>();
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
              Toast.makeText(fragmenthome.this, Interval.get(position), Toast.LENGTH_LONG).show();
          }
          @Override
          public void onNothingSelected(AdapterView<?> parent) {

          }
      });


    }
}
