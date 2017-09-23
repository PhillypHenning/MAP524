package com.map.pahenning_folz.lab_3;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void handle_a2_click(){
        Toast.makeText(this, "You clicked a2_button way to go!", Toast.LENGTH_LONG).show();

        //Implicit intent
        Intent a2_intent = new Intent("com.seneca.lab2.Phil");

        // Intent will be used to start another activity
        startActivityForResult(a2_intent, 1);


    }

    public void handle_a3_click(){
        Toast.makeText(this, "You clicked a3 button, way to go!", Toast.LENGTH_LONG).show();

        Intent a3_intent = new Intent("com.seneca.lab2.Phil.b3");

        startActivity(a3_intent);
        // startActivityForResult expect a intent and a request code so that we can later match
        // up the request with the reply
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Adding button handler for a2_button
        // step1) Get a reference to the button by using findViewById
        // Returns Java reference
        Button a2 = (Button)findViewById(R.id.a2_button); // Casts to the actual view class
        // define a click handling method for the button
        // NOTE: we are using a Java style called an 'Anonymous temporary class'

        a2.setOnClickListener(
            /* instantiate an on click listener object inside the method call braces.*/
            new View.OnClickListener(){
                //Overriding the onclick method of abstract View class.
                public void onClick(View v){
                    // Marek's advice is to add a method to handle behaviour
                    handle_a2_click();
                }
            }
        );

        // OnActivityResult will be called by the android framework once the Activity we started
        // with the startActivityForResult completes.


        Button a3 = (Button)findViewById(R.id.a3_button);
        a3.setOnClickListener(
            new View.OnClickListener(){
                public void onClick(View v){
                    handle_a3_click();
                }
            }
        );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //handler
        if(requestCode == 1){
            // check to see if the user clicked 'ok' or 'back'
            if(resultCode == Activity.RESULT_OK){
                String result = data.getStringExtra("msg");
                // Set text view string to display the msg
                TextView text = (TextView) findViewById(R.id.edit_text);
                text.setText(result);
            }
        }else{
            Log.e("lab2","clever girl");
        }
    }
}
