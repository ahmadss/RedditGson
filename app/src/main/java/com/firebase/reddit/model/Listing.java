package com.firebase.reddit.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ahmad on 20/01/2017.
 */

public class Listing {

//    {
//        "kind": "Listing",
//        "data": {                ambill class listing
//          "modhash": "",
//          "children": [           ambil class childrenarray
//              {
//                 "kind": "t3",
//                 "data": {     ambil class children
//                    "contest_mode": false,
//                    "title"  }  ambil class post

    @SerializedName("data")
    private ChildrenArray childrenArray;

    public List<Post> getPostList(){
        List<Post> postList = new ArrayList<Post>();

        for (Children children : childrenArray.getChildrenList()){
            postList.add(children.getPost());
        }

        return postList;
    }
}
