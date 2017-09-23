package com.map.pahenning_folz.lab_3;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    public void handle_ok_button(){
        Intent result = new Intent();

        // Retrieve the text entered in the EditText box for the reply
        EditText editText = (EditText) findViewById(R.id.edit_text);
        // extract the string stored in editText
        String msg = editText.getText().toString();
        // add a message as an extra to the 'result' Intent
        result.putExtra("msg", msg);

        // if the activity was started with startActivityForResult remember to return the result.
        setResult(Activity.RESULT_OK, result);

        // Finally end the activity by calling finish
        finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button ok = (Button)findViewById(R.id.ok_button);

        ok.setOnClickListener(
            new View.OnClickListener(){
                public void onClick(View v){
                    handle_ok_button();
                }
            }
        );
    }
}
