package com.mrenesinau.remo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mrenesinau.remo.Login.Activity_Login;
import com.mrenesinau.remo.Model.DataMaps;

public class Activity_DetailToko extends AppCompatActivity {

    TextView  showNama, showAlamat, showEmail, showWeb,showInformasi, showNomor;
    private DatabaseReference database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__detail_toko);

        //menampilkan tombol Back
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        showNama = (TextView) findViewById(R.id.showNama);
        showAlamat = (TextView) findViewById(R.id.showAlamat);
        showEmail = (TextView) findViewById(R.id.showEmail);
        showWeb = (TextView) findViewById(R.id.showWeb);
        showInformasi = (TextView) findViewById(R.id.showInformasi);
        showNomor = (TextView) findViewById(R.id.showNomor);



        String id=(getIntent().getBundleExtra("hasil").getString("id"));


        database = FirebaseDatabase.getInstance().getReference("Lokasi").child(id);
        database.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                DataMaps dataMaps=dataSnapshot.getValue(DataMaps.class);
                showNama.setText(dataMaps.getNama());
                showAlamat.setText(dataMaps.getAlamat());
                showEmail.setText(dataMaps.getEmail());
                showWeb.setText(dataMaps.getWeb());
                showInformasi.setText(dataMaps.getInformasi());
                showNomor.setText(dataMaps.getNomer());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
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

            return true;
        } else if (id == R.id.pesan_main) {

            return true;
        } else if (id == R.id.keluar_main) {
            setTitle("Masuk");
            Intent openNewActivityIntent = new Intent(Activity_DetailToko.this,Activity_Login.class);
            startActivity(openNewActivityIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
