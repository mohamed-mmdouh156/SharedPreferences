package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    TextView name , username;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ids();
        sp = getSharedPreferences("user_data" , MODE_PRIVATE);


        String input_name = sp.getString("name" , "no name");
        String input_username = sp.getString("username" , "no username");

        name.setText(input_name);
        username.setText(input_username);

    }

    void ids (){

        name = findViewById(R.id.home_name);
        username = findViewById(R.id.home_username);

    }
}