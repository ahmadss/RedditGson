package com.firebase.reddit.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ahmad on 20/01/2017.
 */

public class Children {

    @SerializedName("data")
    private Post post;

    public Post getPost(){
        return post;
    }
}
