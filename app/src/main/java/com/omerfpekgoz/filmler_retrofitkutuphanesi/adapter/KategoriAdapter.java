package com.omerfpekgoz.filmler_retrofitkutuphanesi.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.omerfpekgoz.filmler_retrofitkutuphanesi.R;
import com.omerfpekgoz.filmler_retrofitkutuphanesi.activity.FilmlerActivity;
import com.omerfpekgoz.filmler_retrofitkutuphanesi.model.Kategori;

import java.util.List;

public class KategoriAdapter extends RecyclerView.Adapter<KategoriAdapter.carViewHolder> {

    private Context mContext;
    private List<Kategori> kategoriList;

    public KategoriAdapter(Context mContext, List<Kategori> kategoriList) {
        this.mContext = mContext;
        this.kategoriList = kategoriList;
    }

    @NonNull
    @Override
    public carViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kategori_card_tasarim, parent, false);

        return new carViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull carViewHolder holder, int position) {

        final Kategori kategori = kategoriList.get(position);

        holder.txtKategoriAd.setText(kategori.getKategoriAd().toString());

        holder.cardViewKategori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent newIntent = new Intent(mContext, FilmlerActivity.class);

                newIntent.putExtra("kategori", kategori);
                mContext.startActivity(newIntent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return kategoriList.size();
    }

    public class carViewHolder extends RecyclerView.ViewHolder {

        private CardView cardViewKategori;
        private TextView txtKategoriAd;


        public carViewHolder(@NonNull View itemView) {
            super(itemView);

            cardViewKategori = itemView.findViewById(R.id.cardViewKategori);
            txtKategoriAd = itemView.findViewById(R.id.txtKategoriAd);

        }
    }
}
