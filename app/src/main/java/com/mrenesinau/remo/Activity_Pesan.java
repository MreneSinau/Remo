package com.mrenesinau.remo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mrenesinau.remo.Common.Common;
import com.mrenesinau.remo.Login.Activity_Daftar;
import com.mrenesinau.remo.Login.Activity_Login;
import com.mrenesinau.remo.Model.Order;
import com.mrenesinau.remo.Model.TambahUser;

import java.util.Calendar;
import java.util.Random;

public class Activity_Pesan extends AppCompatActivity {

    TextView txtidpes, txtdatepes, txtidCat, txtUnitPes, txtNamaMobPes;
    TextView txtTokoPes, belumbayar, txtHargaPes, txtDiskonPes, txtNopolPes;
    EditText txtNamalengPes, txtNotepPes, txtEmailPes, txtDurasiPes, txtAwalPes, txtAhirPes;
    Button btnPesanPes;

    int hari, bulan, tahun;


    private static final Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__pesan);

        btnPesanPes = (Button) findViewById(R.id.btnPesanPes);

        ///
        txtidpes = (TextView) findViewById(R.id.txtidpes);
        int randInt = rand.nextInt(10000) + 1;
        txtidpes.setText(String.valueOf(randInt));


        //ambil tanggal
        Calendar calendar = Calendar.getInstance();
        hari = calendar.get(Calendar.DAY_OF_MONTH);
        bulan = calendar.get(Calendar.MONTH);
        tahun = calendar.get(Calendar.YEAR);
        String hasiltanggal = hari + "/" + bulan + "/" + tahun;

        txtdatepes = (TextView) findViewById(R.id.txtdatepes);
        txtdatepes.setText(hasiltanggal);


        //
        txtidCat = (TextView) findViewById(R.id.txtidCat);
        txtUnitPes = (TextView) findViewById(R.id.txtUnitPes);
        txtNamaMobPes = (TextView) findViewById(R.id.txtNamaMobPes);
        txtTokoPes = (TextView) findViewById(R.id.txtTokoPes);
        txtHargaPes = (TextView) findViewById(R.id.txtHargaPes);
        txtDiskonPes = (TextView) findViewById(R.id.txtDiskonPes);
        belumbayar = (TextView) findViewById(R.id.belumbayar);
        txtNopolPes = (TextView) findViewById(R.id.txtNopolPes);
        /////
        txtNamalengPes = (EditText) findViewById(R.id.txtNamalengPes);
        txtNotepPes = (EditText) findViewById(R.id.txtNotepPes);
        txtEmailPes = (EditText) findViewById(R.id.txtEmailPes);
        txtDurasiPes = (EditText) findViewById(R.id.txtDurasiPes);
        txtAwalPes = (EditText) findViewById(R.id.txtAwalPes);
        txtAhirPes = (EditText) findViewById(R.id.txtAhirPes);


        //isian
        txtidCat = (TextView) findViewById(R.id.txtidCat);
        txtidCat.setText(Common.currentCategory.getId());

        txtUnitPes = (TextView) findViewById(R.id.txtUnitPes);

        txtNamaMobPes = (TextView) findViewById(R.id.txtNamaMobPes);
        txtNamaMobPes.setText(Common.currentCategory.getNama());

        txtTokoPes = (TextView) findViewById(R.id.txtTokoPes);

        txtHargaPes = (TextView) findViewById(R.id.txtHargaPes);
        txtHargaPes.setText(Common.currentCategory.getHarga());

        txtNopolPes = (TextView) findViewById(R.id.txtNopolPes);
        txtNopolPes.setText(Common.currentCategory.getNopol());




        //coneksi firebase
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_pesan = database.getReference("Pesanan");

        btnPesanPes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog mDialog = new ProgressDialog(Activity_Pesan.this);
                mDialog.setMessage("Tunggu Sebentar ....");
                mDialog.show();

                table_pesan.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child(txtidpes.getText().toString()).exists())
                        {
                            Toast.makeText(Activity_Pesan.this, "Data Sudah ada di Database !!!", Toast.LENGTH_LONG).show();
                        } else {

                            mDialog.show();
                            Order order = new Order();
                            order.setIdPes(txtidpes.getText().toString());
                            order.setIdCat(txtidCat.getText().toString());
                            order.setNamaUser(txtNamalengPes.getText().toString());
                            order.setEmail(txtEmailPes.getText().toString());
                            order.setNoHpUser(txtNotepPes.getText().toString());
                            order.setNopoll(txtNopolPes.getText().toString());
                            order.setNamaMobil(txtNamaMobPes.getText().toString());
                            order.setHarga(txtHargaPes.getText().toString());
                            order.setDiskon(txtDiskonPes.getText().toString());
                            order.setDurasi(txtDurasiPes.getText().toString());
                            order.setJumlah(txtUnitPes.getText().toString());
                            order.setAwal(txtAwalPes.getText().toString());
                            order.setAhir(txtAhirPes.getText().toString());
                            order.setNamaRental(txtTokoPes.getText().toString());
                            order.setTanggal(txtdatepes.getText().toString());
                            order.setStatus(belumbayar.getText().toString());

                            table_pesan.child(txtidpes.getText().toString()).setValue(order);
                            Toast.makeText(Activity_Pesan.this, "Pesanan Berhasil", Toast.LENGTH_LONG).show();

                            Intent intent = new Intent(Activity_Pesan.this, Activity_Pembayaran.class);
                            Bundle bundle = new Bundle();
                            bundle.putString("idPes", order.getIdPes());
                            intent.putExtra("hasilPesanan", bundle);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });


            }
        });

    }

}
