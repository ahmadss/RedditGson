package com.firebase.reddit.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ahmad on 20/01/2017.
 */

public class Parent {

    @SerializedName("data")
    private AnakArray anakArray;

    public List<Tampil> getTampilList(){
        List<Tampil> tampilList = new ArrayList<Tampil>();

        for (Anak anak : anakArray.getAnakList()){
            tampilList.add(anak.getTampil());
        }

        return tampilList;
    }
}

