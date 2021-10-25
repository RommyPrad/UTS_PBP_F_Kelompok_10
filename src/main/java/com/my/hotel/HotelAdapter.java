package com.my.hotel;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.HotelViewHolder> {
    private Context mCtx;
    ArrayList<Hotel> hotels;
    ArrayList<Hotel> hotelsFilter = new ArrayList<>();
    boolean visible = false;
    int layout = 0;

    public HotelAdapter(Context mCtx, ArrayList<Hotel> hotels, boolean visible, int layout) {
        this.hotels = hotels;
        hotelsFilter.addAll(hotels);
        this.mCtx = mCtx;
        this.layout = layout;
        this.visible = visible;

    }

    @NonNull
    @Override
    public HotelViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(mCtx);
        View view = layoutInflater.inflate(layout, null);
        final HotelViewHolder holder = new HotelViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HotelViewHolder hotelViewHolder, final int i) {
        final String nama = hotels.get(i).name;
        final String harga = hotels.get(i).price;
        final String tanggal = hotels.get(i).date;
        hotelViewHolder.textViewNama.setText(nama);
        hotelViewHolder.textViewHarga.setText(harga);
        hotelViewHolder.textViewTanggal.setText(tanggal);

//        Log.e("LIST", " "+visible);
        if (layout!=R.layout.recycler_item_booking) {
            hotelViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mCtx, Details.class);
                    Bundle bundle=new Bundle();
                    bundle.putInt("id",i);
                    intent.putExtras(bundle);
                    mCtx.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return hotels.size();
    }

    class HotelViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView textViewNama;
        TextView textViewHarga;
        TextView textViewTanggal;
        ImageView imageViewHotel;

        public HotelViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card_view);
            textViewNama = itemView.findViewById(R.id.textViewName);
            textViewHarga = itemView.findViewById(R.id.textViewPrice);
            textViewTanggal = itemView.findViewById(R.id.textViewDate);
            imageViewHotel = itemView.findViewById(R.id.imageHotel);
            if (!visible) {
                textViewHarga.setVisibility(View.INVISIBLE);
            }
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public void filter(String text) {
        hotels.clear();
        if (text.isEmpty()) {
            hotels.addAll(hotelsFilter);
        } else {
            text = text.toLowerCase();
            for (Hotel hotel : hotelsFilter) {
//                Log.e("LIST",item + " "+item.toLowerCase().contains(text));
                if (hotel.name.toLowerCase().contains(text)) {
                    hotels.add(hotel);
                }
            }
        }
        notifyDataSetChanged();
    }
}
