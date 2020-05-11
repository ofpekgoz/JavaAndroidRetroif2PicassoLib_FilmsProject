package com.omerfpekgoz.filmler_retrofitkutuphanesi.network;


import com.omerfpekgoz.filmler_retrofitkutuphanesi.service.IFilmlerDao;
import com.omerfpekgoz.filmler_retrofitkutuphanesi.service.IKategorilerDao;

public class APIUtils {

    public static final String BASE_URL = "http://www.omerfpekgoz.cf/";

    public static IFilmlerDao getFilmlerDao() {

        return RetrofitClient.getClient(BASE_URL).create(IFilmlerDao.class);

    }

    public static IKategorilerDao getKategorilerDao() {

        return RetrofitClient.getClient(BASE_URL).create(IKategorilerDao.class);

    }
}
