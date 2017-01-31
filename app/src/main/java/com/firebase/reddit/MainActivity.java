package com.firebase.reddit;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.firebase.reddit.database.RedditDAO;
import com.firebase.reddit.model.Parent;
import com.firebase.reddit.model.Tampil;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Adapter.MyListItemClick {

    public final String REDDIT_URL = "https://www.reddit.com/r/all.json?limit=5";
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerListview);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

//        RequestQueue queue = Volley.newRequestQueue(this);
//        RequestQueue queue = KoneksiManager.getInstance(this);

        StringRequest request = new StringRequest(Request.Method.GET, REDDIT_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Parent listing = new Gson().fromJson(response, Parent.class);

                List<Tampil> tampilList = listing.getTampilList();

                Adapter adapter = new Adapter(listing.getTampilList(), MainActivity.this, MainActivity.this);

//                Log.d("simpanlist", "onResponse: "+tampilList);

                RedditDAO.getInstance().simpanTampil(MainActivity.this, tampilList);

                mRecyclerView.setAdapter(adapter);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                List<Tampil> tampilList = RedditDAO.getInstance().getTampilFromDB(MainActivity.this);
//                Log.d("ERRORRESPONSE", "onErrorResponse: ");
//                Toast.makeText(MainActivity.this, tampilList.get(1).getTitle(), Toast.LENGTH_SHORT).show();
//                Log.d("tampil", "onErrorResponse: "+tampilList);
                Adapter adapter = new Adapter(tampilList, MainActivity.this, MainActivity.this);
                mRecyclerView.setAdapter(adapter);
            }
        });

//        queue.add(request);
        KoneksiManager.getInstance(this).add(request);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void OnItemClick(Tampil itemClick) {
        Toast.makeText(MainActivity.this, "item click "+itemClick.getTitle(), Toast.LENGTH_SHORT).show();
    }
}
