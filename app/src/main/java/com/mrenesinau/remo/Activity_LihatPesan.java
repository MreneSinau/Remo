package com.mrenesinau.remo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mrenesinau.remo.Common.Common;
import com.mrenesinau.remo.Interface.ItemClickListener;
import com.mrenesinau.remo.Login.Activity_Login;
import com.mrenesinau.remo.Model.Category;
import com.mrenesinau.remo.Model.Pesanan;
import com.mrenesinau.remo.ViewHolder.MenuViewHolder;
import com.mrenesinau.remo.ViewHolder.PesanViewHolder;
import com.squareup.picasso.Picasso;

public class Activity_LihatPesan extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference pesanan;

    RecyclerView recyle_Pesanan;
    RecyclerView.LayoutManager layoutManager;

    FirebaseRecyclerAdapter<Pesanan,PesanViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__lihat_pesan);


        //menampilkan tombol Back
        getSupportActionBar().setTitle("Pesanan");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //init databse
        database = FirebaseDatabase.getInstance();
        pesanan=database.getReference("Pesanan");


        recyle_Pesanan = (RecyclerView)findViewById(R.id.recyle_Pesanan);
        recyle_Pesanan.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyle_Pesanan.setLayoutManager(layoutManager);

        loadPesan();

    }

    private void loadPesan() {

        final ProgressDialog mDialog = new ProgressDialog(Activity_LihatPesan.this);
        mDialog.setMessage("Tunggu Sebentar ....");
        mDialog.show();

        adapter = new FirebaseRecyclerAdapter<Pesanan, PesanViewHolder>(Pesanan.class,R.layout.item_pesanan,PesanViewHolder.class,pesanan) {
            @Override
            protected void populateViewHolder(PesanViewHolder viewHolder, Pesanan model, int position) {
                mDialog.dismiss();

                viewHolder.TVJudulPesan.setText(model.getNamaMobil());
                viewHolder.TVNamaOrgPes.setText(model.getNamaUser());
                viewHolder.TVJumHarga.setText(model.getHarga());
                viewHolder.TVjumlah.setText(model.getJmlh());
                //Picasso.with(getBaseContext()).load(model.getImage()).into(viewHolder.VimageView);

                final  Pesanan clickItem = model;
                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClik(View view, int position, boolean isLongClik) {

                        Toast.makeText(Activity_LihatPesan.this,""+clickItem.getIdPes(), Toast.LENGTH_SHORT);

                        Intent activity_DetailMobil = new Intent(Activity_LihatPesan.this,Activity_DetailPesan.class);
                        Common.currentPesanan = clickItem;
                        startActivity(activity_DetailMobil);
                        finish();
                    }
                });

            }
        };
        //Log.d("TAG", "" + adapter.getItemCount());
        recyle_Pesanan.setAdapter(adapter);

    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getTitle().equals(Common.DELETE)) {
            deleteItem(adapter.getRef(item.getOrder()).getKey());
        }

        return super.onContextItemSelected(item);
    }

    private void deleteItem(String key) {
        pesanan.child(key).removeValue();
        Toast.makeText(this, "Item Terhapus !!!!", Toast.LENGTH_SHORT).show();
    }


    //Menampilkan Menu Main
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    //Aksi Menu Main
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //menampilkan tombol Back
        if (id== android.R.id.home){
            this.finish();
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.home_main) {
            Intent openNewActivityIntent = new Intent(Activity_LihatPesan.this,MainActivity.class);
            startActivity(openNewActivityIntent);
            return true;
        } else if (id == R.id.pesan_main) {
            setTitle("Pesan Mobil");
            Intent openNewActivityIntent = new Intent(Activity_LihatPesan.this,Activity_Pesan_Categ.class);
            startActivity(openNewActivityIntent);

            return true;
        } else if (id == R.id.keluar_main) {
            setTitle("Masuk");
            Intent openNewActivityIntent = new Intent(Activity_LihatPesan.this,Activity_Login.class);
            startActivity(openNewActivityIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
