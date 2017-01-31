package com.firebase.reddit.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ahmad on 20/01/2017.
 */

public class ChildrenArray {
    @SerializedName("children")
    private List<Children> childrenList;

    public List<Children> getChildrenList(){

        return childrenList;
    }
}
