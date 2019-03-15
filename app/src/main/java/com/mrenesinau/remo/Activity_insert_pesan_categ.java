package com.mrenesinau.remo;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.mrenesinau.remo.Common.Common;
import com.mrenesinau.remo.Interface.ItemClickListener;
import com.mrenesinau.remo.Login.Activity_Login;
import com.mrenesinau.remo.Model.Category;
import com.mrenesinau.remo.Model.InsertCatefory;
import com.mrenesinau.remo.ViewHolder.AdminMenuViewHolder;
import com.mrenesinau.remo.ViewHolder.MenuViewHolder;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.squareup.picasso.Picasso;

import java.util.UUID;

public class Activity_insert_pesan_categ extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference category;

    FirebaseStorage storage;
    StorageReference storageReference;

    RecyclerView inserecyle_Category;
    RecyclerView.LayoutManager layoutManager;

    Category newCategory;
    Uri saveUri;
    private final int PICK_IMAGE_REQUEST = 71;

    //menu layout
    EditText editText, editHarga, editDeskripsi, editTahun, editCC, editPlat, editDiskon, editStok;
    Button button2, button3;
    FloatingActionButton fabb;
    FirebaseRecyclerAdapter<Category, AdminMenuViewHolder> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_pesan_categ);

        //menampilkan tombol Back
        getSupportActionBar().setTitle("Lihat Mobil");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //init databse
        database = FirebaseDatabase.getInstance();
        category = database.getReference("Category");

        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();


        inserecyle_Category = (RecyclerView) findViewById(R.id.inserecyle_Category);
        inserecyle_Category.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        inserecyle_Category.setLayoutManager(layoutManager);


        fabb = (FloatingActionButton) findViewById(R.id.fabb);
        fabb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });

        loadMenuinset();

    }

    private void showDialog() {
        AlertDialog.Builder alsertDialog = new AlertDialog.Builder(Activity_insert_pesan_categ.this);
        alsertDialog.setTitle("Tambah Item");
        alsertDialog.setMessage("Harap semua di isi Dulu !!!");

        LayoutInflater inflater = this.getLayoutInflater();
        View add_menu_layout = inflater.inflate(R.layout.add_menu_layout, null);

        editText = add_menu_layout.findViewById(R.id.editText);
        editHarga = add_menu_layout.findViewById(R.id.editHarga);
        editDeskripsi = add_menu_layout.findViewById(R.id.editDeskripsi);
        editTahun = add_menu_layout.findViewById(R.id.editTahun);
        editCC = add_menu_layout.findViewById(R.id.editCC);
        editPlat = add_menu_layout.findViewById(R.id.editPlat);
        editDiskon = add_menu_layout.findViewById(R.id.editDiskon);
        button2 = (Button) add_menu_layout.findViewById(R.id.button2);
        button3 = (Button) add_menu_layout.findViewById(R.id.button3);
        editStok = add_menu_layout.findViewById(R.id.editStok);


        alsertDialog.setView(add_menu_layout);
        alsertDialog.setIcon(R.drawable.ic_shopping_cart_black_24dp);


        //set button

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Activity_insert_pesan_categ.this, "Button Upload ", Toast.LENGTH_LONG).show();
                uploadImage();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Activity_insert_pesan_categ.this, "Button Pilih", Toast.LENGTH_LONG).show();
                choseImage();
            }
        });

        alsertDialog.setPositiveButton("Refress", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int i) {
                //create category
                if (newCategory != null) {
                    category.push().setValue(newCategory);
                }
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

    //=========================================
    private void uploadImage() {
        if (saveUri != null) {
            final ProgressDialog mDialog = new ProgressDialog(this);
            mDialog.setMessage("Mengunggah ...");

            String imageNama = UUID.randomUUID().toString();
            final StorageReference imageFolder = storageReference.child("images/" + imageNama);
            imageFolder.putFile(saveUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    mDialog.dismiss();
                    Toast.makeText(Activity_insert_pesan_categ.this, "Terunggah !!!", Toast.LENGTH_SHORT).show();
                    imageFolder.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            newCategory = new Category();
                            newCategory.setNama(editText.getText().toString());
                            newCategory.setImage(uri.toString());
                            newCategory.setNama(editText.getText().toString());
                            newCategory.setHarga(editHarga.getText().toString());
                            newCategory.setDeskripsion(editDeskripsi.getText().toString());
                            newCategory.setTahun(editTahun.getText().toString());
                            newCategory.setSilinder(editCC.getText().toString());
                            newCategory.setNopol(editPlat.getText().toString());
                            newCategory.setDiscon(editDiskon.getText().toString());
                            newCategory.setStok(editStok.getText().toString());

                            Log.e("Test", "success!");
                        }
                    });
                }
            })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            mDialog.dismiss();
                            Toast.makeText(Activity_insert_pesan_categ.this, "Galal" + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progeress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                            mDialog.setMessage("Terunggah" + progeress + "%");
                        }
                    });
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            saveUri = data.getData();
            button3.setText("Gamber Terpilih");
        }

    }

    //=========================================
    private void choseImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Pilih Gambar"), PICK_IMAGE_REQUEST);
    }


    private void loadMenuinset() {

        final ProgressDialog mDialog = new ProgressDialog(Activity_insert_pesan_categ.this);
        mDialog.setMessage("Tunggu Sebentar ....");
        mDialog.show();

        adapter = new FirebaseRecyclerAdapter<Category, AdminMenuViewHolder>(Category.class, R.layout.desain_row, AdminMenuViewHolder.class, category) {
            @Override
            protected void populateViewHolder(AdminMenuViewHolder viewHolder, Category model, int position) {
                mDialog.dismiss();

                viewHolder.TVtitleText.setText(model.getNama());
                Picasso.with(getBaseContext()).load(model.getImage()).into(viewHolder.VimageView);

                //final Category clickItem = model;
                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClik(View view, int position, boolean isLongClik) {

                        // Toast.makeText(Activity_insert_pesan_categ.this, "" + clickItem.getId(), Toast.LENGTH_SHORT).show();

                    }
                });

            }
        };
        adapter.notifyDataSetChanged(); //refresh data
        inserecyle_Category.setAdapter(adapter);
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
            Intent openNewActivityIntent = new Intent(Activity_insert_pesan_categ.this, MainActivity.class);
            startActivity(openNewActivityIntent);

        } else if (id == R.id.pesan_main) {
            setTitle("Pesan Mobil");
            //   android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
            //   manager.beginTransaction().replace(R.id.fragment, new Pesan()).commit();

        } else if (id == R.id.keluar_main) {
            setTitle("Masuk");
            Intent openNewActivityIntent = new Intent(Activity_insert_pesan_categ.this, MainActivity_Drawer_user.class);
            startActivity(openNewActivityIntent);

        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getTitle().equals(Common.UPDATE)) {
            showUploadDialog(adapter.getRef(item.getOrder()).getKey(), adapter.getItem(item.getOrder()));
        }
        else if (item.getTitle().equals(Common.DELETE)) {
            deleteItem(adapter.getRef(item.getOrder()).getKey());
        }

        return super.onContextItemSelected(item);
    }

    private void deleteItem(String key) {
        category.child(key).removeValue();
        Toast.makeText(this, "Item Terhapus !!!!", Toast.LENGTH_SHORT).show();
    }

    private void showUploadDialog(final String key, final Category item) {
        AlertDialog.Builder alsertDialog = new AlertDialog.Builder(Activity_insert_pesan_categ.this);
        alsertDialog.setTitle("Update Item");
        alsertDialog.setMessage("Harap semua di isi Dulu !!!");

        LayoutInflater inflater = this.getLayoutInflater();
        View add_menu_layout = inflater.inflate(R.layout.add_menu_layout, null);

        editText = add_menu_layout.findViewById(R.id.editText);
        editHarga = add_menu_layout.findViewById(R.id.editHarga);
        editDeskripsi = add_menu_layout.findViewById(R.id.editDeskripsi);
        editTahun = add_menu_layout.findViewById(R.id.editTahun);
        editCC = add_menu_layout.findViewById(R.id.editCC);
        editPlat = add_menu_layout.findViewById(R.id.editPlat);
        editDiskon = add_menu_layout.findViewById(R.id.editDiskon);
        button2 = (Button) add_menu_layout.findViewById(R.id.button2);
        button3 = (Button) add_menu_layout.findViewById(R.id.button3);
        editStok = add_menu_layout.findViewById(R.id.editStok);

        alsertDialog.setView(add_menu_layout);
        alsertDialog.setIcon(R.drawable.ic_shopping_cart_black_24dp);

        editText.setText(item.getNama());

        //set button
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Activity_insert_pesan_categ.this, "Button Upload ", Toast.LENGTH_LONG).show();
                changeGambar(item);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Activity_insert_pesan_categ.this, "Button Pilih", Toast.LENGTH_LONG).show();
                choseImage();
            }
        });
        alsertDialog.setPositiveButton("Refress", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int i) {

                //update informasi
                item.setNama(editText.getText().toString());

                item.setNama(editText.getText().toString());
                item.setHarga(editHarga.getText().toString());
                item.setDeskripsion(editDeskripsi.getText().toString());
                item.setTahun(editTahun.getText().toString());
                item.setSilinder(editCC.getText().toString());
                item.setNopol(editPlat.getText().toString());
                item.setDiscon(editDiskon.getText().toString());
                item.setStok(editStok.getText().toString());

                category.child(key).setValue(item);
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


    private void changeGambar(final Category item) {
        if (saveUri != null) {
            final ProgressDialog mDialog = new ProgressDialog(this);
            mDialog.setMessage("Mengunggah ...");

            String imageNama = UUID.randomUUID().toString();
            final StorageReference imageFolder = storageReference.child("images/" + imageNama);
            imageFolder.putFile(saveUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    mDialog.dismiss();
                    Toast.makeText(Activity_insert_pesan_categ.this, "Terunggah !!!", Toast.LENGTH_SHORT).show();
                    imageFolder.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {

                            item.setNama(uri.toString());
                        }
                    });
                }
            })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            mDialog.dismiss();
                            Toast.makeText(Activity_insert_pesan_categ.this, "Galal" + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progeress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                            mDialog.setMessage("Terunggah" + progeress + "%");
                        }
                    });
        }
    }
}
