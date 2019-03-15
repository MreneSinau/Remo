package com.mrenesinau.remo.Login;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mrenesinau.remo.Model.TambahUser;
import com.mrenesinau.remo.Model.User;
import com.mrenesinau.remo.R;

public class Activity_Daftar extends AppCompatActivity {

    Button btnDaftarreg;
    EditText pwddaf, userdaf, namafull, alamat, notelp;
    RadioGroup RadioGroup;
    RadioButton RadioButton;
    private static final int TIME_INTERVAL = 2000;
    private long mBackPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__daftar);

        RadioGroup=(RadioGroup)findViewById(R.id.rdGrup);


        pwddaf=(EditText)findViewById(R.id.pwddaf);
        userdaf=(EditText)findViewById(R.id.userdaf);
        namafull=(EditText)findViewById(R.id.namafull);
        alamat=(EditText)findViewById(R.id.alamat);
        notelp=(EditText)findViewById(R.id.notelp);
        btnDaftarreg=(Button) findViewById(R.id.btnDaftarreg);

        //coneksi firebase
        final FirebaseDatabase database=FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        btnDaftarreg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int selectedld = RadioGroup.getCheckedRadioButtonId();
                RadioButton = (RadioButton) findViewById(selectedld);

                final ProgressDialog mDialog = new ProgressDialog(Activity_Daftar.this);
                mDialog.setMessage("Tunggu Sebentar ....");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child(userdaf.getText().toString()).exists())
                        {
                            mDialog.show();
                            Toast.makeText(Activity_Daftar.this, "Data Sudah ada di Database !!!", Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            mDialog.show();
                            TambahUser user=new TambahUser();
                            user.setName(userdaf.getText().toString());
                            user.setPassword(pwddaf.getText().toString());
                            user.setAlamat(alamat.getText().toString());
                            user.setJkel(RadioButton.getText().toString());
                            user.setNamalengkap(namafull.getText().toString());
                            user.setNohp(notelp.getText().toString());

                            table_user.child(userdaf.getText().toString()).setValue(user);
                            Toast.makeText(Activity_Daftar.this, "Pendaftaran Berhasil!", Toast.LENGTH_LONG).show();
                            finish();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });


            }
        });

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
