package com.mrenesinau.remo.Login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mrenesinau.remo.Activity_Profile;
import com.mrenesinau.remo.MainActivity;
import com.mrenesinau.remo.MainActivity_admin;
import com.mrenesinau.remo.Model.User;
import com.mrenesinau.remo.Common.Common;
import com.mrenesinau.remo.R;

public class Activity_Login extends AppCompatActivity {

    Button btnDaftar, btnMasuk;
    TextView userlog, pwdlog;
    private static final int TIME_INTERVAL = 2000;
    private long mBackPressed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__login);

        userlog=(EditText)findViewById(R.id.userlog);
        pwdlog=(EditText)findViewById(R.id.pwdlog);

        btnDaftar=(Button)findViewById(R.id.btnDaftar);
        btnMasuk=(Button)findViewById(R.id.btnMasuk);

        //coneksi firebase
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        btnMasuk.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                final ProgressDialog mDialog = new ProgressDialog(Activity_Login.this);
                mDialog.setMessage("Tunggu Sebentar ....");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        // mengambil data informasi tabel user
                        if (dataSnapshot.child(userlog.getText().toString()).exists()) {
                        mDialog.dismiss();

                            User user = dataSnapshot.child(userlog.getText().toString()).getValue(User.class);

                            if (user.getPassword().equals(pwdlog.getText().toString())) {
                                {
                                   // Toast.makeText(Activity_Login.this, "Belum di isi !!!", Toast.LENGTH_LONG).show();

                                    Intent mainActivity = new Intent(Activity_Login.this,MainActivity.class);
                                    Common.currentUser = user;
                                    startActivity(mainActivity);
                                    finish();
                                }

                            } else {
                                Toast.makeText(Activity_Login.this, "Login Gagal !!!", Toast.LENGTH_LONG).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(Activity_Login.this, "Tidak ada di Database !!!", Toast.LENGTH_LONG).show();
                            mDialog.show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }

                    });
                }
            }
        );

        btnDaftar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent openNewActivityIntent = new Intent(Activity_Login.this, Activity_Daftar.class);
                startActivity(openNewActivityIntent);
            }
           }
        );
    }

    @Override
    public void onBackPressed()
    {
        if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis())
        {
            super.onBackPressed();
            return;
        }
        else { Toast.makeText(getBaseContext(), "Tekan Back Sekali lagi untuk Keluar", Toast.LENGTH_SHORT).show(); }

        mBackPressed = System.currentTimeMillis();

    }

}
