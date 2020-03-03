package com.example.materialdesign;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
public class Signin extends AppCompatActivity {
EditText sname, pssd;
Button lgn,register;
String password, username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sname = findViewById(R.id.username);
        pssd = findViewById(R.id.password);
        lgn = findViewById(R.id.button);
        register= findViewById(R.id.Register);

        lgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           password= pssd.getText().toString();
           username= sname.getText().toString();

           if(password.isEmpty()) {

               Toast.makeText(Signin.this, "CHECK YOUR PASSWORD PLEASE", Toast.LENGTH_SHORT).show();
           }else if (
                   username.isEmpty()){
                Toast.makeText(Signin.this, "TYPE IN YOUR USERNAME PLEASE", Toast.LENGTH_SHORT).show();
           }
           else
           {

               String url="http://www.olande.co.ke/databaselogin.php?username="+sname.getText().toString()+"&password="+pssd.getText().toString();

               RequestQueue requestQueue= Volley.newRequestQueue(Signin.this);

               JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                   @Override
                   public void onResponse(JSONObject response) {

                       try {
                           String string=response.getString("status");
                           if (string.equals("true")){

                               Toast.makeText(Signin.this, "login successful", Toast.LENGTH_LONG).show();
                               Intent intent=new Intent(Signin.this,AutoSlideshow.class);
                               startActivity(intent);
                           } else {
                               Toast.makeText(Signin.this, "wrong username or password", Toast.LENGTH_LONG).show();
                           }
                       } catch (JSONException e) {
                           e.printStackTrace();
                       }
                   }
               }, new Response.ErrorListener() {
                   @Override
                   public void onErrorResponse(VolleyError error) {
                       Toast.makeText(Signin.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                   }
               });

               requestQueue.add(request);

           }
            }

      }

      );

  register.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
          Intent intent = new Intent(Signin.this, Register.class);
          startActivity(intent);

      }
  });


    }
}
