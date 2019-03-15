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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mancj.materialsearchbar.MaterialSearchBar;
import com.mrenesinau.remo.Common.Common;
import com.mrenesinau.remo.Interface.ItemClickListener;
import com.mrenesinau.remo.Login.Activity_Login;
import com.mrenesinau.remo.Model.Category;
import com.mrenesinau.remo.ViewHolder.MenuViewHolder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Activity_Pesan_Categ extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference category;

    RecyclerView recyle_Category;
    RecyclerView.LayoutManager layoutManager;

    FirebaseRecyclerAdapter<Category, MenuViewHolder> adapter;
    FirebaseRecyclerAdapter<Category, MenuViewHolder> searchAdapter;
    List<String> stringList = new ArrayList<>();
    MaterialSearchBar materialSearchBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__pesan__categ);


        //menampilkan tombol Back
        getSupportActionBar().setTitle("Lihat Mobil");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //init databse
        database = FirebaseDatabase.getInstance();
        category = database.getReference("Category");


        recyle_Category = (RecyclerView) findViewById(R.id.recyle_Category);
        recyle_Category.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyle_Category.setLayoutManager(layoutManager);

        loadMenu();


    }


    private void loadMenu() {

        final ProgressDialog mDialog = new ProgressDialog(Activity_Pesan_Categ.this);
        mDialog.setMessage("Tunggu Sebentar ....");
        mDialog.show();

        adapter = new FirebaseRecyclerAdapter<Category, MenuViewHolder>(Category.class, R.layout.desain_row, MenuViewHolder.class, category) {
            @Override
            protected void populateViewHolder(MenuViewHolder viewHolder, Category model, int position) {
                mDialog.dismiss();

                viewHolder.TVtitleText.setText(model.getNama());
                Picasso.with(getBaseContext()).load(model.getImage()).into(viewHolder.VimageView);

                final Category clickItem = model;
                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClik(View view, int position, boolean isLongClik) {

                        Toast.makeText(Activity_Pesan_Categ.this, "" + clickItem.getId(), Toast.LENGTH_SHORT);

                        Intent activity_DetailMobil = new Intent(Activity_Pesan_Categ.this, Activity_DetailMobil.class);
                        Common.currentCategory = clickItem;
                        startActivity(activity_DetailMobil);
                        finish();
                    }
                });

            }
        };
        Log.d("TAG", "" + adapter.getItemCount());
        recyle_Category.setAdapter(adapter);

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
        if (id == android.R.id.home) {
            this.finish();
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.home_main) {
            setTitle("Remo");
            Intent openNewActivityIntent = new Intent(Activity_Pesan_Categ.this, MainActivity_Drawer_user.class);
            startActivity(openNewActivityIntent);

        } else if (id == R.id.pesan_main) {
            setTitle("Pesan Mobil");
            //   android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
            //   manager.beginTransaction().replace(R.id.fragment, new Pesan()).commit();

        } else if (id == R.id.keluar_main) {
            setTitle("Masuk");
            Intent openNewActivityIntent = new Intent(Activity_Pesan_Categ.this, Activity_Login.class);
            startActivity(openNewActivityIntent);

        }
        return super.onOptionsItemSelected(item);
    }
}
