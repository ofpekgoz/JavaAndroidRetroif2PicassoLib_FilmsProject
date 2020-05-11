package com.omerfpekgoz.filmler_retrofitkutuphanesi.model;


import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KategoriCevap implements Serializable {

    @SerializedName("kategoriler")
    @Expose
    private List<Kategori> kategoriler = null;
    @SerializedName("success")
    @Expose
    private Integer success;

    public List<Kategori> getKategoriler() {
        return kategoriler;
    }

    public void setKategoriler(List<Kategori> kategoriler) {
        this.kategoriler = kategoriler;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

}