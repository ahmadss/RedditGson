package com.firebase.reddit;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
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

public class Adapter extends RecyclerView.Adapter<Adapter.myViewHolder> {

    List<Tampil> mTampilList;
    Context mContext;
    MyListItemClick mListener;

    public Adapter(List<Tampil> tampilList, Context context, MyListItemClick listener) {
        mTampilList = tampilList;
        mContext = context;
        mListener = listener;
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_post, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {
        Tampil currentTampil = mTampilList.get(position);

        holder.mTextViewRow.setText(mTampilList.get(position).getTitle());
        if (!TextUtils.isEmpty(currentTampil.getThumbnailURL())) {
            ((View)holder.networkImageView.getParent()).setVisibility(View.VISIBLE);
            holder.networkImageView.setImageUrl(currentTampil.getThumbnailURL(), KoneksiManager.getImageLoader(mContext));
        } else {
            ((View)holder.networkImageView.getParent()).setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return mTampilList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView mTextViewRow;
        public NetworkImageView networkImageView;

        public myViewHolder(View itemView) {
            super(itemView);
            mTextViewRow = (TextView) itemView.findViewById(R.id.rowTextViewName);
            networkImageView = (NetworkImageView) itemView.findViewById(R.id.rowNetworkImageView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mListener.OnItemClick(mTampilList.get(getPosition()));
        }
    }

    public static interface MyListItemClick{
        void OnItemClick(Tampil itemClick);
    }
}
