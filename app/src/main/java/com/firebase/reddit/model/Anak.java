package com.firebase.reddit.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ahmad on 20/01/2017.
 */

public class Anak {

    @SerializedName("data")
    private Tampil tampil;

    public Tampil getTampil(){
        return tampil;
    }
}
