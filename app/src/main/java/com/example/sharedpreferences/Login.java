package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText username , password;
    Button Login ;
    SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ids();

        sp = getSharedPreferences("user_data" , MODE_PRIVATE);

        String input_username = username.getText().toString();
        String input_password = password.getText().toString();

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String real_username = sp.getString("username","no_name");
                String real_password = sp.getString("password","no_password");
                String real_name = sp.getString("name" ,"no_name");

                if(input_username.equals(real_username) && input_password.equals(real_password)){

                    Toast.makeText(getBaseContext() , "Login Successful" , Toast.LENGTH_LONG).show();
                    Intent to_home = new Intent(Login.this , Home.class);
                    startActivity(to_home);
                }
                else if(!input_username.equals(real_username)){
                    Toast.makeText(getBaseContext() , "incorrect username" , Toast.LENGTH_LONG).show();
                }
                else if(!input_password.equals(real_password)){
                    Toast.makeText(getBaseContext() , "incorrect password" , Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getBaseContext() , "incorrect username and password" , Toast.LENGTH_LONG).show();
                }

            }
        });


    }

    void ids (){
        username = findViewById(R.id.login_username_et);
        password = findViewById(R.id.login_password_et);
        Login = findViewById(R.id.login_login_btn);
    }
}