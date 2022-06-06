package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText userName, userPassword;
    Button loginBtn;

    String _userName, _userPassword;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("auth",MODE_PRIVATE);

       _userName  = sharedPreferences.getString("userName","");
       _userPassword =  sharedPreferences.getString("userPassword","");


        Log.d("userName",_userName);
        Log.d("userPassword",_userPassword);

        if (_userName.equals("admin") && _userPassword.equals("admin")) {
            Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);

            startActivity(intent);
        }


        //
       userName = findViewById(R.id.userName);
       userPassword = findViewById(R.id.userPassword);
       loginBtn = findViewById(R.id.loginBtn);


       loginBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               _userName = userName.getText().toString().trim();
               _userPassword = userPassword.getText().toString().trim();

               if (_userName.equals("admin") && _userPassword.equals("admin")) {

                   SharedPreferences.Editor editor = sharedPreferences.edit();

                   editor.putString("userName", "admin");
                   editor.putString("userPassword", "admin");

                   editor.apply();

                   Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);

                   startActivity(intent);
               }
           }
       });
    }
}