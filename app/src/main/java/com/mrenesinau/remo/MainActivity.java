package com.mrenesinau.remo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mrenesinau.remo.Common.Common;
import com.mrenesinau.remo.Fragment.Bantuan;
import com.mrenesinau.remo.Fragment.Home;
import com.mrenesinau.remo.Fragment.Tentang;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    TextView txtNamaLengkap;
    ImageView imageProfil;

    private static final int TIME_INTERVAL = 2000;
    private long mBackPressed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Home");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction() .replace(R.id.fragment,new Home()) .commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        //menampilkan Nama lengkap
        View headerView = navigationView.getHeaderView(0);
        txtNamaLengkap = (TextView)headerView.findViewById(R.id.txtNamaLengkap);
        txtNamaLengkap.setText(Common.currentUser.getName());


    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
                if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis())
                {
                    super.onBackPressed();
                    return;
                }
                else { Toast.makeText(getBaseContext(), "Tekan Back Sekali lagi untuk Keluar", Toast.LENGTH_SHORT).show(); }
                mBackPressed = System.currentTimeMillis();

            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.home_main) {
            setTitle("Remo");
            android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction() .replace(R.id.fragment,new Home()) .commit();
            return true;
        } else if (id == R.id.pesan_main) {
            setTitle("Pesan Mobil");
            Intent openNewActivityIntent = new Intent(MainActivity.this,Activity_Pesan_Categ.class);
            startActivity(openNewActivityIntent);
            return true;
        } else if (id == R.id.keluar_main) {
            setTitle("Masuk");
            Intent openNewActivityIntent = new Intent(MainActivity.this,MainActivity_Drawer_user.class);
            startActivity(openNewActivityIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_profil) {
            setTitle("Profil");
            Intent openNewActivityIntent = new Intent(MainActivity.this,Activity_Profile.class);
            startActivity(openNewActivityIntent);

        } else if (id == R.id.nav_maps) {
            setTitle("Maps");
            Intent openNewActivityIntent = new Intent(MainActivity.this,item_maps.class);
            startActivity(openNewActivityIntent);

        } else if (id == R.id.nav_pesan) {
            setTitle("Pesan Mobil");
            Intent openNewActivityIntent = new Intent(MainActivity.this,Activity_Pesan_Categ.class);
            startActivity(openNewActivityIntent);

        } else if (id == R.id.nav_about) {
            setTitle("Tentang Kami");
            android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction() .replace(R.id.fragment,new Tentang()) .commit();

        } else if (id == R.id.nav_help) {
            setTitle("Bantuan");
            android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction() .replace(R.id.fragment,new Bantuan()) .commit();

        } else if (id == R.id.nav_llogout) {
            setTitle("Masuk");
            Intent openNewActivityIntent = new Intent(MainActivity.this, MainActivity_Drawer_user.class);
            startActivity(openNewActivityIntent);

        }else if (id == R.id.nav_tambahmobil) {
            setTitle("Masuk");
            Intent openNewActivityIntent = new Intent(MainActivity.this, Activity_insert_pesan_categ.class);
            startActivity(openNewActivityIntent);

        }else if (id == R.id.nav_Pesanan) {
            setTitle("Pesanan");
            Intent openNewActivityIntent = new Intent(MainActivity.this, Activity_LihatPesan.class);
            startActivity(openNewActivityIntent);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
