package com.mrenesinau.remo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mrenesinau.remo.Common.Common;
import com.mrenesinau.remo.Login.Activity_Login;

public class Activity_DetailPesan extends AppCompatActivity {

    TextView showNamaMobil, showharga, showjmlh, shownamaUser, showemail, shownohp, showtglmesan, showdurasi, showtglawal;
    TextView showtglahir, shownamatoko, showplatnomor, showdiskon, showstatus;

    FirebaseDatabase database;
    DatabaseReference detailpesan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__detail_pesan);

        //menampilkan tombol Back
        getSupportActionBar().setTitle("Detail Pesanan");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Firrebsease
        database = FirebaseDatabase.getInstance();
        detailpesan = database.getReference("Pesanan");


        showNamaMobil = (TextView) findViewById(R.id.showNamaMobil);
        showharga = (TextView) findViewById(R.id.showharga);
        showjmlh = (TextView) findViewById(R.id.showjmlh);
        shownamaUser = (TextView) findViewById(R.id.shownamaUser);
        showemail = (TextView) findViewById(R.id.showemail);
        shownohp = (TextView) findViewById(R.id.shownohp);
        showtglmesan = (TextView) findViewById(R.id.showtglmesan);
        showdurasi = (TextView) findViewById(R.id.showdurasi);
        showtglawal = (TextView) findViewById(R.id.showtglawal);
        showtglahir = (TextView) findViewById(R.id.showtglahir);
        shownamatoko = (TextView) findViewById(R.id.shownamatoko);
        showplatnomor = (TextView) findViewById(R.id.showplatnomor);
        showdiskon = (TextView) findViewById(R.id.showdiskon);
        showstatus = (TextView) findViewById(R.id.showstatus);


        //======================================================
        showNamaMobil = (TextView) findViewById(R.id.showNamaMobil);
        showNamaMobil.setText(Common.currentPesanan.getNamaMobil());

        showharga = (TextView) findViewById(R.id.showharga);
        showharga.setText(Common.currentPesanan.getHarga());

        showjmlh = (TextView) findViewById(R.id.showjmlh);
        showjmlh.setText(Common.currentPesanan.getJmlh());

        shownamaUser = (TextView) findViewById(R.id.shownamaUser);
        shownamaUser.setText(Common.currentPesanan.getNamaUser());


        showemail = (TextView) findViewById(R.id.showemail);
        showemail.setText(Common.currentPesanan.getEmail());

        shownohp = (TextView) findViewById(R.id.shownohp);
        shownohp.setText(Common.currentPesanan.getNoHpUser());

        showtglmesan = (TextView) findViewById(R.id.showtglmesan);
        showtglmesan.setText(Common.currentPesanan.getTanggal());

        showdurasi = (TextView) findViewById(R.id.showdurasi);
        showdurasi.setText(Common.currentPesanan.getDurasi());

        showtglawal = (TextView) findViewById(R.id.showtglawal);
        showtglawal.setText(Common.currentPesanan.getAwal());

        showtglahir = (TextView) findViewById(R.id.showtglahir);
        showtglahir.setText(Common.currentPesanan.getAhir());

        shownamatoko = (TextView) findViewById(R.id.shownamatoko);
        shownamatoko.setText(Common.currentPesanan.getNamaRental());

        showplatnomor = (TextView) findViewById(R.id.showplatnomor);
        showplatnomor.setText(Common.currentPesanan.getNopoll());

        showdiskon = (TextView) findViewById(R.id.showdiskon);
        showdiskon.setText(Common.currentPesanan.getDiskon());

        showstatus = (TextView) findViewById(R.id.showstatus);
        showstatus.setText(Common.currentPesanan.getStatus());
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
            Intent openNewActivityIntent = new Intent(Activity_DetailPesan.this, MainActivity.class);
            startActivity(openNewActivityIntent);
            return true;
        } else if (id == R.id.pesan_main) {
            setTitle("Pesan Mobil");
            Intent openNewActivityIntent = new Intent(Activity_DetailPesan.this, Activity_Pesan_Categ.class);
            startActivity(openNewActivityIntent);

            return true;
        } else if (id == R.id.keluar_main) {
            setTitle("Masuk");
            Intent openNewActivityIntent = new Intent(Activity_DetailPesan.this, Activity_Login.class);
            startActivity(openNewActivityIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
