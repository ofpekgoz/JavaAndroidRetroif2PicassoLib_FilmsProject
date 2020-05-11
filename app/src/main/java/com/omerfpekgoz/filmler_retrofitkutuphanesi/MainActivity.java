package com.omerfpekgoz.filmler_retrofitkutuphanesi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.omerfpekgoz.filmler_retrofitkutuphanesi.adapter.KategoriAdapter;
import com.omerfpekgoz.filmler_retrofitkutuphanesi.model.Kategori;
import com.omerfpekgoz.filmler_retrofitkutuphanesi.model.KategoriCevap;
import com.omerfpekgoz.filmler_retrofitkutuphanesi.network.APIUtils;
import com.omerfpekgoz.filmler_retrofitkutuphanesi.service.IKategorilerDao;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


//RETROFİT VE PİCASSO KÜTÜPHANELERİNİ EKLEDİK
//implementation"com.squareup.retrofit2:retrofit:2.3.0"+
//implementation "com.squareup.retrofit2:converter-gson:2.3.0
// https://mvnrepository.com/artifact/com.squareup.picasso/picasso
//compile group:'com.squareup.picasso',name:'picasso',version:'2.5.2'


public class MainActivity extends AppCompatActivity {

    private RecyclerView recViewKategori;
    private Toolbar toolbarMain;

    private KategoriAdapter kategoriAdapter;
    private ArrayList<Kategori> kategoriArrayList;

    private IKategorilerDao kategorilerDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recViewKategori = findViewById(R.id.recViewKategori);
        toolbarMain = findViewById(R.id.toolbarMain);

        toolbarMain.setTitle("KATEGORİLER");
        setSupportActionBar(toolbarMain);


        kategorilerDao = APIUtils.getKategorilerDao();


        recViewKategori.setHasFixedSize(true);
        recViewKategori.setLayoutManager(new LinearLayoutManager(this));


        tumKategoriler();

    }

    public void tumKategoriler() {
        Log.e("MEsaj","Mesaj");
        kategorilerDao.tumKategoriler().enqueue(new Callback<KategoriCevap>() {
            @Override
            public void onResponse(Call<KategoriCevap> call, Response<KategoriCevap> response) {


                List<Kategori> kategoriList = new ArrayList<>();
                kategoriList = response.body().getKategoriler();

                kategoriAdapter = new KategoriAdapter(MainActivity.this, kategoriList);
                recViewKategori.setAdapter(kategoriAdapter);
            }

            @Override
            public void onFailure(Call<KategoriCevap> call, Throwable t) {

            }
        });
    }
}
