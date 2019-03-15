package com.mrenesinau.remo.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mrenesinau.remo.Common.Common;
import com.mrenesinau.remo.Interface.ItemClickListener;
import com.mrenesinau.remo.R;

/**
 * Created by adipu on 12/01/2018.
 */

public class PesanViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnCreateContextMenuListener {

    public TextView TVJudulPesan;
    public TextView TVjumlah;
    public TextView TVJumHarga;
    public TextView TVNamaOrgPes;

    private ItemClickListener itemClickListener;

    public PesanViewHolder(View itemView) {
        super(itemView);
        TVJudulPesan = (TextView) itemView.findViewById(R.id.JudulPesan);
        TVjumlah = (TextView) itemView.findViewById(R.id.jumlah);
        TVJumHarga = (TextView) itemView.findViewById(R.id.JumHarga);
        TVNamaOrgPes = (TextView) itemView.findViewById(R.id.NamaOrgPes);
       // TVpesanan_produk = (ImageView) itemView.findViewById(R.id.pesanan_produk);

        itemView.setOnCreateContextMenuListener(this);
        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClik(v,getAdapterPosition(),false);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("Pilih Aksi..");

        menu.add(0,0,getAdapterPosition(), Common.DELETE);
    }
}
