package com.firebase.reddit;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.firebase.reddit.model.Tampil;

import java.util.List;

/**
 * Created by ahmad on 20/01/2017.
 */

public class RedditAdapter extends RecyclerView.Adapter<RedditAdapter.MyViewHolder> {

    List<Tampil> mPostsList;
    Context mContext;

    public RedditAdapter(List<Tampil> postsList, Context context){
        mPostsList = postsList;
        mContext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_post,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Tampil currentTampil = mPostsList.get(position);
        holder.mTextViewViewPostName.setText(mPostsList.get(position).getTitle());
        holder.mTampilIamge.setImageUrl(currentTampil.getThumbnailURL(), KoneksiManager.getImageLoader(mContext));
    }

    @Override
    public int getItemCount() {
        return mPostsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView mTextViewViewPostName;
        public NetworkImageView mTampilIamge;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewViewPostName = (TextView)itemView.findViewById(R.id.rowTextViewName);
            mTampilIamge =  (NetworkImageView)itemView.findViewById(R.id.rowNetworkImageView);
        }
    }
}
