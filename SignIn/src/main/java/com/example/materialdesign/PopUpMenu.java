package com.example.materialdesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PopUpMenu extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_menu);

        button=findViewById(R.id.button);

      //  button.setOnClickListener(new View.OnClickListener() {
        //    @Override
         //   public void onClick(View v) {
             //   PopupMenu popupMenu= new PopupMenu(getApplicationContext(),button);
             //   popupMenu.inflate(R.menu.popup_menu);
             //   popupMenu.show();
             //   popupMenu.setOnMenuItemClickListener(PopUpMenu.this);

            }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        return false;
    }
    //  });
 //   }

   // @Override
  //  public boolean onMenuItemClick(MenuItem item) {
       // switch (item.getItemId()){
          //  case R.id.item1:

             //   Toast.makeText(this, "Daily basis", Toast.LENGTH_LONG).show();
               // return true;
          //  switch (item.getItemId()){
          //      case R.id.item1:

             ///       Toast.makeText(this, "Daily basis", Toast.LENGTH_LONG).show();
              //      return true;
              //  switch (item.getItemId()){
                 //   case R.id.item1:

                  ///      Toast.makeText(this, "Daily basis", Toast.LENGTH_LONG).show();
                   //     return true;
                    //switch (item.getItemId()){
                    //    case R.id.item1:

                        //    Toast.makeText(this, "Daily basis", Toast.LENGTH_LONG).show();
                        ///    return true;
                        //switch (item.getItemId()){
                          //  case R.id.item1:

                               // Toast.makeText(this, "Daily basis", Toast.LENGTH_LONG).show();
                               // return true;
                             //   default:
    //    return false;


    //    }


  //  @Override
  // public void onPointerCaptureChanged(boolean hasCapture) {

    }

