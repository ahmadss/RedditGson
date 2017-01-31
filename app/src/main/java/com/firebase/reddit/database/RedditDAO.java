package com.firebase.reddit.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.firebase.reddit.model.Tampil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ahmad on 20/01/2017.
 */

public class RedditDAO {

    /**
     * Singleton Pattern
     */
    private static RedditDAO sInstance = null;

    /**
     * Get an Instance of database access Object
     * @return
     */
    public static RedditDAO getInstance(){
        if (sInstance == null){
            sInstance = new RedditDAO();
        }

        return sInstance;
    }

    public boolean simpanTampil(Context context, List<Tampil> tampilList){

        List<Tampil> simpanTampils  = RedditDAO.getInstance().getTampilFromDB(context);

        try {
            SQLiteDatabase db = new DatabaseOpenHelper(context).getWritableDatabase();

            db.beginTransaction();
            for (Tampil tampil : tampilList){

                boolean isInDb = false;

                for (Tampil tampilSimpan : simpanTampils){
                    if (tampil.getTitle().equals(tampilSimpan.getTitle())){
                        isInDb = true;
                    }
                }

                if (!isInDb){
                    ContentValues cv = new ContentValues();
                    cv.put(DatabaseConstract.TampilTable.TITLE, tampil.getTitle());
                    cv.put(DatabaseConstract.TampilTable.LINK, tampil.getPermalink());
                    cv.put(DatabaseConstract.TampilTable.IMAGELINK, tampil.getThumbnailURL());

                    db.insert(DatabaseConstract.TampilTable.TABLE_NAME, null, cv);
                }
            }

            db.setTransactionSuccessful();
            db.endTransaction();

            db.close();
        } catch (Exception e){
            return false;
        }

        return true;
    }

    public List<Tampil> getTampilFromDB(Context context){
        SQLiteDatabase db = new DatabaseOpenHelper(context).getWritableDatabase();

        Cursor cursor = db.query(DatabaseConstract.TampilTable.TABLE_NAME, null, null, null, null, null, null);

        cursor.moveToFirst();

        List<Tampil> tampilList = new ArrayList<>();

        while (cursor.moveToNext()) {
            String title = cursor.getString(cursor.getColumnIndex(DatabaseConstract.TampilTable.TITLE));
            String link = cursor.getString(cursor.getColumnIndex(DatabaseConstract.TampilTable.LINK));
            String imageLink = cursor.getString(cursor.getColumnIndex(DatabaseConstract.TampilTable.IMAGELINK));

            Tampil tampil = new Tampil(title, link, imageLink);

            tampilList.add(tampil);
        }

        cursor.close();
        db.close();

        return tampilList;
    }
}
