package com.dio.satriani.sadehan_gamelan.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dio.satriani.sadehan_gamelan.Beans.Iklan;
import com.dio.satriani.sadehan_gamelan.R;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by user on 3/19/2018.
 */

public class IklanAdapter extends RecyclerView.Adapter<IklanAdapter.CustomViewHolder>  {

    private List<Iklan> iklans;

    public IklanAdapter(List<Iklan> iklans) {
        this.iklans = iklans;
    }

    @Override
    public IklanAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_iklan, parent, false);

        return new IklanAdapter.CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(IklanAdapter.CustomViewHolder holder, int position) {
        Iklan iklan = iklans.get(position);
        holder.tvnama.setText(iklan.getUsername());
        holder.tvharga.setText(iklan.getTelephone());
//        Picasso.get().load(iklan.getImage()).error(R.mipmap.ic_launcher).into(holder.iviklan);

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView tvnama, tvharga;
        public ImageView iviklan;

        public CustomViewHolder(View view) {
            super(view);
            tvnama = (TextView) view.findViewById(R.id.tvNama);
            tvharga = (TextView) view.findViewById(R.id.tvHarga);
//            iviklan = view.findViewById(R.id.iv_iklan);
        }
    }
}
