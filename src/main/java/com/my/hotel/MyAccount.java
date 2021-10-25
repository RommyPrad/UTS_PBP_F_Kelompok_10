package com.my.hotel;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

public class MyAccount extends Activity {

    private SharedPreferences sharedPref;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myaccount);

        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        ImageView x = findViewById(R.id.close);
        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        TextView textViewName=findViewById(R.id.topName);
        textViewName.setText(Global.akun.name);
        TextView textViewEmail=findViewById(R.id.topEmail);
        textViewEmail.setText(Global.akun.email);

        final EditText editTextName=findViewById(R.id.textName);
        editTextName.setText(Global.akun.name);
        final EditText editTextAddress=findViewById(R.id.textAddress);
        editTextAddress.setText(Global.akun.address);
        final EditText editTextPhone=findViewById(R.id.textPhone);
        editTextPhone.setText(Global.akun.phone);
        final EditText editTextEmail=findViewById(R.id.textEmail);
        editTextEmail.setText(Global.akun.email);

        View editName=findViewById(R.id.editName);
        editName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor = sharedPref.edit();
                Gson gson = new Gson();
                editor.remove(Global.akun.email.concat(Global.akun.password));
                Global.akun.name=editTextName.getText().toString();
                String json = gson.toJson(Global.akun);
                editor.putString(Global.akun.email.concat(Global.akun.password),json);
                editor.apply();
                Toast.makeText(getApplicationContext(),"Update Sukses",Toast.LENGTH_SHORT).show();
            }
        });
        View editPhone=findViewById(R.id.editPhone);
        editPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor = sharedPref.edit();
                Gson gson = new Gson();
                editor.remove(Global.akun.email.concat(Global.akun.password));
                Global.akun.phone=editTextPhone.getText().toString();
                String json = gson.toJson(Global.akun);
                editor.putString(Global.akun.email.concat(Global.akun.password),json);
                editor.apply();
                Toast.makeText(getApplicationContext(),"Update Sukses",Toast.LENGTH_SHORT).show();
            }
        });
        View editAddress=findViewById(R.id.editAddress);
        editAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor = sharedPref.edit();
                Gson gson = new Gson();
                editor.remove(Global.akun.email.concat(Global.akun.password));
                Global.akun.address=editTextAddress.getText().toString();
                String json = gson.toJson(Global.akun);
                editor.putString(Global.akun.email.concat(Global.akun.password),json);
                editor.apply();
                Toast.makeText(getApplicationContext(),"Update Sukses",Toast.LENGTH_SHORT).show();
            }
        });
        View editEmail=findViewById(R.id.editEmail);
        editEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor = sharedPref.edit();
                Gson gson = new Gson();
                editor.remove(Global.akun.email.concat(Global.akun.password));
                Global.akun.email=editTextEmail.getText().toString();
                String json = gson.toJson(Global.akun);
                editor.putString(Global.akun.email.concat(Global.akun.password),json);
                editor.apply();
                Toast.makeText(getApplicationContext(),"Update Sukses",Toast.LENGTH_SHORT).show();
            }
        });

        Button settings = findViewById(R.id.buttonSettings);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(Sidebar.this, Login.class));
            }
        });

    }
}

