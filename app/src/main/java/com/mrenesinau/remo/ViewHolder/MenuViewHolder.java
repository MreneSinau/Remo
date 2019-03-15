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
 * Created by adipu on 09/01/2018.
 */

public class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView TVtitleText;
    public ImageView VimageView;

    private ItemClickListener itemClickListener;

    public MenuViewHolder(View itemView) {
        super(itemView);

        TVtitleText = (TextView) itemView.findViewById(R.id.titleText);
        VimageView = (ImageView) itemView.findViewById(R.id.imageView);

        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClik(v,getAdapterPosition(),false);

    }
}
