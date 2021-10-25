package com.my.hotel;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.preference.PreferenceManager;

import com.google.gson.Gson;

import java.util.ArrayList;

public class Login extends Activity {

    SharedPreferences appSharedPrefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        appSharedPrefs= PreferenceManager
                .getDefaultSharedPreferences(this.getApplicationContext());

        final EditText editTextEmail=findViewById(R.id.editTextEmail);
        final EditText editTextPassword=findViewById(R.id.editTextPassword);


        Button back=findViewById(R.id.buttonBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        Button login = findViewById(R.id.buttonLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password=editTextPassword.getText().toString();
                String email=editTextEmail.getText().toString();

                Gson gson = new Gson();
                String json = appSharedPrefs.getString(email.concat(password), "");
                Akun akun = gson.fromJson(json, Akun.class);

                if(akun!=null){
                    Global.akun=akun;
                    Global.bookingHotel.clear();
                    startActivity(new Intent(Login.this, Home.class));
                }
                else{
                    Toast.makeText(getApplicationContext(),"Login gagal",Toast.LENGTH_SHORT).show();
                }
            }
        });

        TextView signup = findViewById(R.id.sign_up);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, Signup.class));
                onBackPressed();
            }
        });

    }


}
