package com.example.materialdesign;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;
import org.json.JSONObject;
public class Register extends AppCompatActivity {
    TextInputEditText Name,pass,Email,phone,username;
    Button  register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        Name=(TextInputEditText) findViewById(R.id.name);
        Email=(TextInputEditText) findViewById(R.id.email);
        register= findViewById(R.id.submit);
        pass=findViewById(R.id.password);
        phone=findViewById(R.id.pnumber);
        username=(TextInputEditText)findViewById(R.id.username);

        register.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Toast.makeText(Register.this, "sending data", Toast.LENGTH_LONG).show();
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        String url="http://www.olande.co.ke/registerandroid.php?name="+Name.getText().toString()+"&phone="+phone.getText().toString()+"&password="+pass.getText().toString()+"&email="+Email.getText().toString()+"&username="+username.getText();
        JsonObjectRequest jsonObjectRequest= new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(Register.this, "response", Toast.LENGTH_LONG).show();
                try {
                    if (response.getString("status").equals("true")){
                        Toast.makeText(Register.this, "register success", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Register.this, AutoSlideshow.class);
                        startActivity(intent);

                    }else {

                        Toast.makeText(Register.this, response.getString("message"), Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Register.this, error.getMessage(), Toast.LENGTH_LONG).show();

            }
        });

        requestQueue.add(jsonObjectRequest);

    }});


    }}

