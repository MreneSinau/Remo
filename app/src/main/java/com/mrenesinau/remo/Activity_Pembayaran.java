package com.mrenesinau.remo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mrenesinau.remo.Model.DataMaps;
import com.mrenesinau.remo.Model.Order;

import java.util.concurrent.TimeUnit;

public class Activity_Pembayaran extends AppCompatActivity implements View.OnClickListener {

    private TextView textView2, txtTimer;
    DatabaseReference database;

    ImageView imageView1, imageView2, imageView3, imageView4;
    TextView rekening1, rekening2, rekening3, rekening4;

    Button btnTrasnfer, btnKeToko, btnKonfirmasi;
    private static final String FORMAT = "%02d:%02d:%02d";

    int seconds, minutes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__pembayaran);

        textView2 = (TextView) findViewById(R.id.textView2);
        txtTimer = (TextView) findViewById(R.id.txtTimer);

        btnTrasnfer = (Button) findViewById(R.id.btnTrasnfer);
        btnTrasnfer.setOnClickListener(this);

        btnKeToko = (Button) findViewById(R.id.btnKeToko);
        btnKeToko.setOnClickListener(this);

        btnKonfirmasi = (Button) findViewById(R.id.btnKonfirmasi);
        btnKonfirmasi.setOnClickListener(this);


        String id = (getIntent().getBundleExtra("hasilPesanan").getString("idPes"));
        database = FirebaseDatabase.getInstance().getReference("Pesanan").child(id);
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Order order = dataSnapshot.getValue(Order.class);
                textView2.setText(order.getStatus());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    //Alter Dialog
    private void showDialog() {
        AlertDialog.Builder alsertDialog = new AlertDialog.Builder(Activity_Pembayaran.this);
        alsertDialog.setTitle("Pilih Bank");
        alsertDialog.setMessage("Transfer Ke Rekening !!!");

        LayoutInflater inflater = this.getLayoutInflater();
        View layout_pembayaran = inflater.inflate(R.layout.layout_pembayaran, null);


        imageView1 = layout_pembayaran.findViewById(R.id.imageView1);
        rekening1 = layout_pembayaran.findViewById(R.id.rekening1);

        imageView2 = layout_pembayaran.findViewById(R.id.imageView2);
        rekening2 = layout_pembayaran.findViewById(R.id.rekening2);


        alsertDialog.setPositiveButton("Refress", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int i) {

            }
        });


        alsertDialog.setNeutralButton("Cansel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {


            }
        });
        alsertDialog.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {

            }
        });
        alsertDialog.show();
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnTrasnfer) {
            showDialog();
            new CountDownTimer(3600000, 1000) { // adjust the milli seconds here
                public void onTick(long millisUntilFinished) {
                    txtTimer.setText("" + String.format(FORMAT,
                            TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                            TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
                                    TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                            TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
                }

                public void onFinish() {
                    finish();
                }
            }.start();
        } else if (v.getId() == R.id.btnKeToko) {
            Toast.makeText(Activity_Pembayaran.this, "Transfer Ke Toko", Toast.LENGTH_SHORT).show();

            new CountDownTimer(3600000, 1000) { // adjust the milli seconds here
                public void onTick(long millisUntilFinished) {
                    txtTimer.setText("" + String.format(FORMAT,
                            TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                            TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
                                    TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                            TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
                }

                public void onFinish() {
                    finish();
                }
            }.start();
        } else if (v.getId() == R.id.btnKonfirmasi) {

        }

    }
}
