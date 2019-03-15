package com.mrenesinau.remo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.mrenesinau.remo.Fragment.Bantuan;
import com.mrenesinau.remo.Fragment.Fragment_Home_User;
import com.mrenesinau.remo.Fragment.Home;
import com.mrenesinau.remo.Fragment.Tentang;
import com.mrenesinau.remo.Login.Activity_Login;

public class MainActivity_Drawer_user extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__drawer_user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        setTitle("Home");
        android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction() .replace(R.id.fragment,new Fragment_Home_User()) .commit();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity__drawer_user, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_Home) {
            setTitle("Home");
            android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction() .replace(R.id.fragment,new Fragment_Home_User()) .commit();

            return true;
        }else if (id == R.id.action_Pesan) {

            return true;
        } else if (id == R.id.action_Login) {
            setTitle("Masuk");
            Intent openNewActivityIntent = new Intent(MainActivity_Drawer_user.this, Activity_Login.class);
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

        if (id == R.id.nav_mapsSr) {
            setTitle("Maps");
            Intent openNewActivityIntent = new Intent(MainActivity_Drawer_user.this,item_maps.class);
            startActivity(openNewActivityIntent);

        } else if (id == R.id.nav_pesanSr) {
            setTitle("Pesan");
            Intent openNewActivityIntent = new Intent(MainActivity_Drawer_user.this, Activity_Pesan_Categ.class);
            startActivity(openNewActivityIntent);

        } else if (id == R.id.nav_aboutSr) {
            setTitle("Tentang Kami");
            android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction() .replace(R.id.fragment,new Tentang()) .commit();

        } else if (id == R.id.nav_helpSr) {
            setTitle("Bantuan");
            android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction() .replace(R.id.fragment,new Bantuan()) .commit();

        } else if (id == R.id.nav_loinSr) {
            setTitle("Masuk");
            Intent openNewActivityIntent = new Intent(MainActivity_Drawer_user.this, Activity_Login.class);
            startActivity(openNewActivityIntent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
