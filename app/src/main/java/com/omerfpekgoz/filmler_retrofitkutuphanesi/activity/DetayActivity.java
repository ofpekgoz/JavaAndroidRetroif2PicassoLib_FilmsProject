package com.omerfpekgoz.filmler_retrofitkutuphanesi.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.omerfpekgoz.filmler_retrofitkutuphanesi.R;
import com.omerfpekgoz.filmler_retrofitkutuphanesi.model.Filmler;
import com.squareup.picasso.Picasso;

public class DetayActivity extends AppCompatActivity {

    private ImageView imageDetayResim;
    private TextView txtDetayFilmAdi,txtDetayFilmYili,txtDetayFilmYonetmen;

    private Filmler film;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);

        imageDetayResim=findViewById(R.id.imageDetayResim);
        txtDetayFilmAdi=findViewById(R.id.txtDetayFilmAdi);
        txtDetayFilmYili=findViewById(R.id.txtDetayFilmYili);
        txtDetayFilmYonetmen=findViewById(R.id.txtDetayFilmYonetmen);

        film= (Filmler) getIntent().getSerializableExtra("film");

        String url="http://www.omerfpekgoz.cf/filmler/resimler/"+film.getFilmResim();
        Picasso.with(DetayActivity.this).load(url).into(imageDetayResim);
        txtDetayFilmAdi.setText(film.getFilmAd());
        txtDetayFilmYili.setText(film.getFilmYil());
        txtDetayFilmYonetmen.setText(film.getYonetmen().getYonetmenAd());



    }
}
