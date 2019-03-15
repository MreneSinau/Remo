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

public class Activity_Profile extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference category;
    TextView txtNamaLengProfil, txtAlamatProfil, txtJkelProfil, txtNotlepProfil, txtUsernaProfil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Profile");
        setContentView(R.layout.activity__profile);

        //menampilkan tombol Back
        getSupportActionBar().setTitle("Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtNamaLengProfil = (TextView) findViewById(R.id.txtNamaLengkap);
        txtAlamatProfil = (TextView) findViewById(R.id.txtAlamatProfil);
        txtJkelProfil = (TextView) findViewById(R.id.txtJkelProfil);
        txtNotlepProfil = (TextView) findViewById(R.id.txtNotlepProfil);
        txtUsernaProfil = (TextView) findViewById(R.id.txtUsernaProfil);

        //Manggil dari data login
        txtNamaLengProfil = (TextView)findViewById(R.id.txtNamaLengProfil);
        txtNamaLengProfil.setText(Common.currentUser.getNamalengkap());

        txtAlamatProfil = (TextView)findViewById(R.id.txtAlamatProfil);
        txtAlamatProfil.setText(Common.currentUser.getAlamat());

        txtJkelProfil = (TextView)findViewById(R.id.txtJkelProfil);
        txtJkelProfil.setText(Common.currentUser.getJkel());

        txtNotlepProfil = (TextView)findViewById(R.id.txtNotlepProfil);
        txtNotlepProfil.setText(Common.currentUser.getNohp());

        txtUsernaProfil = (TextView)findViewById(R.id.txtUsernaProfil);
        txtUsernaProfil.setText(Common.currentUser.getName());

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
            setTitle("Remo");
            Intent openNewActivityIntent = new Intent(Activity_Profile.this,MainActivity.class);
            startActivity(openNewActivityIntent);

        } else if (id == R.id.pesan_main) {
            setTitle("Pesan Mobil");
         //   android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
         //   manager.beginTransaction().replace(R.id.fragment, new Pesan()).commit();

        } else if (id == R.id.keluar_main) {
            setTitle("Masuk");
            Intent openNewActivityIntent = new Intent(Activity_Profile.this,Activity_Login.class);
            startActivity(openNewActivityIntent);

        }
        return super.onOptionsItemSelected(item);
    }
}
