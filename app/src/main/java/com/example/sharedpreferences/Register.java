package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    EditText username , name , password;
    Button save ;
    SharedPreferences sp;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ids();

        sp = getSharedPreferences("user_data",MODE_PRIVATE);
        editor = sp.edit();

        String input_username = username.getText().toString();
        String input_name = name.getText().toString();
        String input_password = password.getText().toString();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editor.putString("name" , input_name);
                editor.putString("username" , input_username);
                editor.putString("password" , input_password);
                editor.apply();

                Toast.makeText(getBaseContext() , "Register Successful" , Toast.LENGTH_LONG).show();
                Intent to_login = new Intent(Register.this , Login.class);
                startActivity(to_login);
            }
        });

    }

    void ids (){
        username = findViewById(R.id.register_username_et);
        name = findViewById(R.id.register_name_et);
        password = findViewById(R.id.register_password_et);
        save = findViewById(R.id.register_register_btn);
    }



}