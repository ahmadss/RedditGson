package com.firebase.reddit.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ahmad on 20/01/2017.
 */

public class Post {

    @SerializedName("permalink")
    private String permalink;

    @SerializedName("thumbnail")
    private String thumbnailURL;

    @SerializedName("title")
    private String title;

    public String getPermalink() {
        return permalink;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public String getTitle() {
        return title;
    }
}
