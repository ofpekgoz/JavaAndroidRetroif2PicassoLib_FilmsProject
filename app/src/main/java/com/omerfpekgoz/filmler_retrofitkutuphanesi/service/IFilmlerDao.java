package com.omerfpekgoz.filmler_retrofitkutuphanesi.service;

import com.omerfpekgoz.filmler_retrofitkutuphanesi.model.FilmCevap;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface IFilmlerDao {

    @POST("filmler/filmler_by_kategori_id.php")     //Kategoriye göre film çağırdığımız için POST kullandık
    @FormUrlEncoded
    Call<FilmCevap> tumFilmlerByKategoriId(@Field("kategori_id") int kategori_id);


}
