package com.example.pahenning_folz.lab_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void handle_b1_click(){
        // Retrieve message text and create message payload
        TextView tempText = new TextView(this);
        TextView text_view = (TextView) findViewById(R.id.main_textview_ac);
        String user_input = text_view.getText().toString();

        // Search for matching input string, add definition if true.
        String[] lab_desc = getResources().getStringArray(R.array.lab_descriptions);
        String[] lab_def = getResources().getStringArray(R.array.lab_definitions);
        int i = 0;
        for (String item : lab_desc){
            if(user_input.equals(item)){
                user_input = item  + " " + lab_def[i];
            }
        }
        
        tempText.setText(user_input);

        // Define position of output
        LinearLayout linear_layout = (LinearLayout) findViewById(R.id.main_layout_1);

        // Configure position settings
        LinearLayout.LayoutParams layout_params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        //Add the new view to the LinearLayout
        linear_layout.addView(tempText, layout_params);

        //clear input
        text_view.setText("");
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1 = (Button)findViewById(R.id.main_button_one);
        b1.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        handle_b1_click();

                    }
                }

        );

        AutoCompleteTextView a_textview = (AutoCompleteTextView)findViewById(R.id.main_textview_ac);

        String[] lab_desc = getResources().getStringArray(R.array.lab_descriptions);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lab_desc);
        a_textview.setAdapter(adapter);


        /* LAB 3 PARTS */
        // Create textView and add it to the linear layout
        TextView tempText = new TextView(this);
        tempText.setText("This is just to demo adding views at run time. - Dynamically add text later");

        LinearLayout linear_layout = (LinearLayout) findViewById(R.id.main_layout_1);

        // before we add the textview to the linear layout we need to specify layout paramenters.
        // This is done with helper class. LinearLayout.LayoutParams
        LinearLayout.LayoutParams layout_params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        //Add the new view to the LinearLayout
        linear_layout.addView(tempText, layout_params);
    }
}


/*
* TO-DO
*
* Clear button & textarea upon clicking
* Add dictonary definitions
* parse definitions
*
* */