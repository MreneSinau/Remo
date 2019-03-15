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
 * Created by adipu on 14/01/2018.
 */

public class AdminMenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnCreateContextMenuListener{

    public TextView TVtitleText;
    public ImageView VimageView;

    private ItemClickListener itemClickListener;

    public AdminMenuViewHolder(View itemView) {
        super(itemView);
        TVtitleText = (TextView) itemView.findViewById(R.id.titleText);
        VimageView = (ImageView) itemView.findViewById(R.id.imageView);

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

        menu.add(0,0,getAdapterPosition(), Common.UPDATE);
        menu.add(0,1,getAdapterPosition(), Common.DELETE);
    }
}
