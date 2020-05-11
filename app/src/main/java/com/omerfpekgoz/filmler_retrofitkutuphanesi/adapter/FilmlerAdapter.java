package com.omerfpekgoz.filmler_retrofitkutuphanesi.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.omerfpekgoz.filmler_retrofitkutuphanesi.activity.DetayActivity;
import com.omerfpekgoz.filmler_retrofitkutuphanesi.R;
import com.omerfpekgoz.filmler_retrofitkutuphanesi.model.Filmler;
import com.omerfpekgoz.filmler_retrofitkutuphanesi.model.Kategori;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FilmlerAdapter extends RecyclerView.Adapter<FilmlerAdapter.cardFilmViewHolder> {

    private Context mContext;
    private List<Filmler> filmList;

    private Kategori kategori;

    public FilmlerAdapter(Context mContext, List<Filmler> filmList) {
        this.mContext = mContext;
        this.filmList = filmList;
    }

    @NonNull
    @Override
    public cardFilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.filmler_card_tasarim, parent, false);

        return new cardFilmViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull cardFilmViewHolder holder, int position) {

        final Filmler film=filmList.get(position);

        holder.txtFilmAdi.setText(film.getFilmAd().toString());

        String url="http://www.omerfpekgoz.cf/filmler/resimler/"+film.getFilmResim();
        Picasso.with(mContext).load(url).into(holder.imageFilmResim);

        holder.cardViewFilm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent newIntent = new Intent(mContext, DetayActivity.class);
                newIntent.putExtra("film",film);
                mContext.startActivity(newIntent);


            }
        });


    }

    @Override
    public int getItemCount() {
        return filmList.size();
    }


    public class cardFilmViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageFilmResim;
        private TextView txtFilmAdi;
        private CardView cardViewFilm;


        public cardFilmViewHolder(@NonNull View itemView) {
            super(itemView);

            cardViewFilm = itemView.findViewById(R.id.cardViewFilm);
            imageFilmResim = itemView.findViewById(R.id.imageFilmResim);
            txtFilmAdi = itemView.findViewById(R.id.txtFilmAdi);

        }
    }
}
