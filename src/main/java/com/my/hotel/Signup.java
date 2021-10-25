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

public class Signup extends Activity {

    private SharedPreferences sharedPref;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        final EditText editTextName=findViewById(R.id.editTextName);
        final EditText editTextEmail=findViewById(R.id.editTextEmail);
        final EditText editTextPassword=findViewById(R.id.editTextPassword);

        Button create = findViewById(R.id.buttonCreate);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password=editTextPassword.getText().toString();
                String email=editTextEmail.getText().toString();
                String name=editTextName.getText().toString();

                Akun akun=new Akun(name,email,"","",password);
                Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();

                editor = sharedPref.edit();
                Gson gson = new Gson();
                String json = gson.toJson(akun);
                editor.putString(email.concat(password),json);
                editor.apply();
            }
        });

        Button back=findViewById(R.id.buttonBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        TextView login = findViewById(R.id.log_in);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Signup.this, Login.class));
                onBackPressed();
            }
        });
    }
}

