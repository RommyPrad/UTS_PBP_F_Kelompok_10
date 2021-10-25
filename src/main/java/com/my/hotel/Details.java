package com.my.hotel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Details extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);

        Button back = findViewById(R.id.buttonBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        Bundle bundle = getIntent().getExtras();
        final int id = bundle.getInt("id");

        TextView textViewName=findViewById(R.id.hotelname);
        textViewName.setText(Global.hotels.get(id).name);
        TextView textViewHarga=findViewById(R.id.hotelprice);
        textViewHarga.setText(Global.hotels.get(id).price);

        View view = findViewById(R.id.bookThis);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Hotel hotel = Global.hotels.get(id);
                if (!Global.bookingHotel.contains(hotel)) {
                    Global.bookingHotel.add(hotel);
                    Toast.makeText(getApplicationContext(), "Booking sukses", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(getApplicationContext(), "Sudah Booking", Toast.LENGTH_SHORT).show();
            }
        });


    }
}

