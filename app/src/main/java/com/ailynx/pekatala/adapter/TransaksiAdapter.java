package com.ailynx.pekatala.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ailynx.pekatala.R;
import com.ailynx.pekatala.model.Transaksi;

import java.util.ArrayList;

/**
 * Created by Indra Tirta Nugraha on 22/05/2017.
 */

public class TransaksiAdapter extends RecyclerView.Adapter {

    private ArrayList<Transaksi> dataTransaksi;
    private onListItemClick listener;
    private Context context;

    public TransaksiAdapter(ArrayList<Transaksi> data, onListItemClick listener) {
        this.dataTransaksi = data;
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_item_transaksi, null);
        return new VHTransaksi(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((VHTransaksi) holder).bind(position);
    }

    @Override
    public int getItemCount() {
        return dataTransaksi.size();
    }

    class VHTransaksi extends RecyclerView.ViewHolder {
        TextView info_list, title_list, subtitle_list;
        RelativeLayout parent_list;

        public VHTransaksi(View itemView) {
            super(itemView);

            parent_list = (RelativeLayout) itemView.findViewById(R.id.parent_list);
            info_list = (TextView) itemView.findViewById(R.id.info_list);
            title_list = (TextView) itemView.findViewById(R.id.title_list);
            subtitle_list = (TextView) itemView.findViewById(R.id.subtitle_list);

            parent_list.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(getAdapterPosition());
                }
            });
        }

        void bind(int position) {
            Transaksi transaksi = dataTransaksi.get(position);
            String info = transaksi.getInfo();

            if (info.equalsIgnoreCase("Baik")){
                info_list.setBackgroundResource(R.drawable.box_green);
            } else if (info.equalsIgnoreCase("Cukup")){
                info_list.setBackgroundResource(R.drawable.box_orange);
            } else if (info.equalsIgnoreCase("Buruk")){
                info_list.setBackgroundResource(R.drawable.box_red);
            }
            info_list.setText(info);
            info_list.setPadding(dpToPx(8), dpToPx(8), dpToPx(8), dpToPx(8));

            title_list.setText(transaksi.getTitle());
            subtitle_list.setText(transaksi.getSubtitle());
        }
    }
    public interface onListItemClick {
        void onItemClick(int position);
    }
    public int dpToPx(int dp) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int px = Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
        return px;
    }

}
