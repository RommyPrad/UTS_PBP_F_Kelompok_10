package com.my.hotel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Home extends Activity {


    RecyclerView recyclerView;
    HotelAdapter hotelAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        Global.hotels.clear();
        Global.hotels.add(new Hotel("Hotel 1","Rp. 10000","21 Jan 2021"));
        Global.hotels.add(new Hotel("Hotel 2","Rp. 20000","12 Feb 2020"));
        Global.hotels.add(new Hotel("Hotel 3","Rp. 30000","4 Dec 2019"));
        Global.hotels.add(new Hotel("Hotel 4","Rp. 40000","6 Jun 2021"));

        TextView name=findViewById(R.id.homename);
        String nameValue="Hey "+Global.akun.name;
        name.setText(nameValue);

        ImageView hamburger=findViewById(R.id.hamburger);
        hamburger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, Sidebar.class));
            }
        });

        TextView viewmore=findViewById(R.id.viewmore);
        viewmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, Explore.class));
            }
        });

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setHasFixedSize(true);
        hotelAdapter = new HotelAdapter(this,Global.hotels,false,R.layout.recycler_item_home);
        recyclerView.setAdapter(hotelAdapter);

        final SearchView searchView=findViewById(R.id.searchView);
        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchView.setIconified(false);
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                hotelAdapter.filter(newText);
                return true;
            }
        });

        };
    }

