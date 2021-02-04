package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button Login , Register ;
    SharedPreferences sp;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ids();

        sp = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sp.edit();

        editor.putString("name" , "Mohamed");
        editor.apply();

        String username = sp.getString("name" , "no name");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent to_login = new Intent(MainActivity.this , Login.class);
                startActivity(to_login);
            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent to_register = new Intent(MainActivity.this , Register.class);
                startActivity(to_register);
            }
        });


    }

    void ids(){

        Login = findViewById(R.id.login_btn);
        Register = findViewById(R.id.register_btn);

    }

}