package com.example.materialdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class RegisterAs extends AppCompatActivity {
  ImageView landlord,merchants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_as);
        landlord=(ImageView)findViewById(R.id.Landlord);
        merchants=(ImageView)findViewById(R.id.Merchant);


        landlord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RegisterAs.this,Signin.class );
                startActivity(intent);
            }
        });

        merchants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent= new Intent(RegisterAs.this, Merchants.class);
                startActivity(intent);
            }
        });

    }
}
