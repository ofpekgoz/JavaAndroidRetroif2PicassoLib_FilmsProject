package com.omerfpekgoz.filmler_retrofitkutuphanesi.service;

import com.omerfpekgoz.filmler_retrofitkutuphanesi.model.KategoriCevap;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IKategorilerDao {

    @GET("filmler/tum_kategoriler.php")
    Call<KategoriCevap> tumKategoriler();


}
