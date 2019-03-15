package com.mrenesinau.remo;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mrenesinau.remo.Common.Common;
import com.mrenesinau.remo.Model.Category;
import com.mrenesinau.remo.Model.Mobil;
import com.mrenesinau.remo.Model.Order;
import com.squareup.picasso.Picasso;

public class Activity_DetailMobil extends AppCompatActivity implements View.OnClickListener {

    TextView JudulMobil, HargaMobil, MobilDeskripsi, keterangan, txttahun, txtsilinder, txtNopol, txtstok, txtDiskon;
    ImageView img_mobil;
    CollapsingToolbarLayout collapsingToolbarLayout;
    FloatingActionButton btnCart;
    ElegantNumberButton numberButton;

    String categoryId = "";

    FirebaseDatabase database;
    DatabaseReference detailmobil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__detail_mobil);

        //Firrebsease
        database = FirebaseDatabase.getInstance();
        detailmobil = database.getReference("Category");

        //int view
        numberButton = (ElegantNumberButton) findViewById(R.id.number_button);
        btnCart = (FloatingActionButton) findViewById(R.id.btnCart);
        btnCart.setOnClickListener(this);


        MobilDeskripsi = (TextView) findViewById(R.id.MobilDeskripsi);
        JudulMobil = (TextView) findViewById(R.id.JudulMobil);
        HargaMobil = (TextView) findViewById(R.id.HargaMobil);
        keterangan = (TextView) findViewById(R.id.keterangan);
        txttahun = (TextView) findViewById(R.id.txttahun);
        txtsilinder = (TextView) findViewById(R.id.txtsilinder);
        txtNopol = (TextView) findViewById(R.id.txtNopol);
        txtstok = (TextView) findViewById(R.id.txtstok);
        txtDiskon = (TextView) findViewById(R.id.txtDiskon);
        img_mobil = (ImageView) findViewById(R.id.img_mobil);

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppbar);
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppbar);

        //menampilkan
        img_mobil = (ImageView) findViewById(R.id.img_mobil);
        Picasso.with(getBaseContext()).load(Common.currentCategory.getImage()).into(img_mobil);

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing);
        collapsingToolbarLayout.setTitle(Common.currentCategory.getNama());

        HargaMobil = (TextView) findViewById(R.id.HargaMobil);
        HargaMobil.setText(Common.currentCategory.getHarga());

        JudulMobil = (TextView) findViewById(R.id.JudulMobil);
        JudulMobil.setText(Common.currentCategory.getNama());

        keterangan = (TextView) findViewById(R.id.keterangan);
        keterangan.setText(Common.currentCategory.getDeskripsion());

        txttahun = (TextView) findViewById(R.id.txttahun);
        txttahun.setText(Common.currentCategory.getTahun());

        txtsilinder = (TextView) findViewById(R.id.txtsilinder);
        txtsilinder.setText(Common.currentCategory.getSilinder());

        txtNopol = (TextView) findViewById(R.id.txtNopol);
        txtNopol.setText(Common.currentCategory.getNopol());

        txtstok = (TextView) findViewById(R.id.txtstok);
        txtstok.setText(Common.currentCategory.getStok());

        txtDiskon = (TextView) findViewById(R.id.txtDiskon);
        txtDiskon.setText(Common.currentCategory.getDiscon());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCart: {
                setTitle("Pesan");
                Intent openIntent = new Intent(Activity_DetailMobil.this, Activity_Pesan.class);
                startActivity(openIntent);

            }
            break;

            default: {
            }
            break;
        }

    }
}
