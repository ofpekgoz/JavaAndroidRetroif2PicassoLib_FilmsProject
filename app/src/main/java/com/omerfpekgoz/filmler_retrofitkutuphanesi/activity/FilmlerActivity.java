package com.omerfpekgoz.filmler_retrofitkutuphanesi.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import com.omerfpekgoz.filmler_retrofitkutuphanesi.R;
import com.omerfpekgoz.filmler_retrofitkutuphanesi.adapter.FilmlerAdapter;
import com.omerfpekgoz.filmler_retrofitkutuphanesi.model.FilmCevap;
import com.omerfpekgoz.filmler_retrofitkutuphanesi.model.Filmler;
import com.omerfpekgoz.filmler_retrofitkutuphanesi.model.Kategori;
import com.omerfpekgoz.filmler_retrofitkutuphanesi.network.APIUtils;
import com.omerfpekgoz.filmler_retrofitkutuphanesi.service.IFilmlerDao;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmlerActivity extends AppCompatActivity {

    private RecyclerView recViewFilmler;
    private Toolbar toolbarFilmlerActivity;

    private FilmlerAdapter filmlerAdapter;
    private ArrayList<Filmler> filmArrayList;

    private IFilmlerDao filmlerDao;

    private Kategori kategori;
    private int kategori_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filmler);

        recViewFilmler=findViewById(R.id.recViewFilmler);
        toolbarFilmlerActivity=findViewById(R.id.toolbarFilmlerActivity);

        kategori= (Kategori) getIntent().getSerializableExtra("kategori");

        kategori_id=Integer.parseInt(kategori.getKategoriId());

        filmlerDao= APIUtils.getFilmlerDao();

        toolbarFilmlerActivity.setTitle(kategori.getKategoriAd());
        setSupportActionBar(toolbarFilmlerActivity);

        recViewFilmler.setHasFixedSize(true);
        recViewFilmler.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        tumFilmlerByKategoriId();

    }

    public void tumFilmlerByKategoriId(){


       filmlerDao.tumFilmlerByKategoriId(kategori_id).enqueue(new Callback<FilmCevap>() {
           @Override
           public void onResponse(Call<FilmCevap> call, Response<FilmCevap> response) {

               List<Filmler> filmlerList=new ArrayList<>();

               filmlerList=response.body().getFilmler();
               filmlerAdapter=new FilmlerAdapter(FilmlerActivity.this,filmlerList);
               recViewFilmler.setAdapter(filmlerAdapter);
           }

           @Override
           public void onFailure(Call<FilmCevap> call, Throwable t) {

           }
       });



    }
}
