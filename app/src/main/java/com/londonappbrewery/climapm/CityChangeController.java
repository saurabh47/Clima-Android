package com.londonappbrewery.climapm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class CityChangeController extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_city_layout);

        final EditText editText=(EditText) findViewById(R.id.queryET);
        ImageButton backButton=(ImageButton)findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String newCity=editText.getText().toString();
                Intent newCityIntent=new Intent(CityChangeController.this,WeatherController.class);

                Log.d("clima",newCity);
                newCityIntent.putExtra("city",newCity);
                startActivity(newCityIntent);

                return false;
            }
        });

    }
}
