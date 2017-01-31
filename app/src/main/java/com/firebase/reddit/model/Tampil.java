package com.firebase.reddit.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ahmad on 20/01/2017.
 */

public class Tampil {
    @SerializedName("permalink")
    private String permalink;

    @SerializedName("thumbnail")
    private String thumbnailURL;

    @SerializedName("title")
    private String title;

    public Tampil(String title, String link, String imageLink) {
        this.title = title;
        this.permalink = link;
        this.thumbnailURL = imageLink;
    }

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
