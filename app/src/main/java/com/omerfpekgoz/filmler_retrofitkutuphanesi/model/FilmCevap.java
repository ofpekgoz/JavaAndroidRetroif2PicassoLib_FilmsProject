package com.omerfpekgoz.filmler_retrofitkutuphanesi.model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FilmCevap implements Serializable {

    @SerializedName("filmler")
    @Expose
    private List<Filmler> filmler = null;
    @SerializedName("success")
    @Expose
    private Integer success;

    public List<Filmler> getFilmler() {
        return filmler;
    }

    public void setFilmler(List<Filmler> filmler) {
        this.filmler = filmler;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

}
