package com.firebase.reddit.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ahmad on 20/01/2017.
 */

public class AnakArray {
    @SerializedName("children")
    private List<Anak> anakList;

    public List<Anak> getAnakList(){
        return anakList;
    }
}
