package com.firebase.reddit;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by ahmad on 20/01/2017.
 */

public class KoneksiManager {

    private static  RequestQueue sQueue;
    private static ImageLoader sImageLoader;

    public static RequestQueue getInstance(Context context){
        if (sQueue == null){
            sQueue = Volley.newRequestQueue(context);
        }

        return sQueue;
    }

    public static ImageLoader getImageLoader(Context context){
        if (sImageLoader == null){
            sImageLoader = new ImageLoader(getInstance(context), new ImageLoader.ImageCache() {

                private final LruCache<String, Bitmap> mCache = new LruCache<String, Bitmap>(10);

                @Override
                public Bitmap getBitmap(String url) {
                    return mCache.get(url);
                }

                @Override
                public void putBitmap(String url, Bitmap bitmap) {
                    mCache.put(url, bitmap);
                }
            });
        }

        return sImageLoader;
    }

//    RequestQueue queue = Volley.newRequestQueue(this);
}
