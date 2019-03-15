package com.mrenesinau.remo.Model;

/**
 * Created by adipu on 28/12/2017.
 */

public class Category {
    private String Nama;
    private String Image;
    private String Id;
    private String Tahun;
    private String Silinder;
    private String Deskripsion;
    private String Discon;
    private String Harga;
    private String Stok;
    private String Nopol;

    public Category() {
    }

    public Category(String nama, String image, String id, String tahun, String silinder, String deskripsion, String discon, String harga, String stok, String nopol) {
        Nama = nama;
        Image = image;
        Id = id;
        Tahun = tahun;
        Silinder = silinder;
        Deskripsion = deskripsion;
        Discon = discon;
        Harga = harga;
        Stok = stok;
        Nopol =nopol;
    }
/*
    public Category(String nama, String image, String id) {
        Nama = nama;
        Image = image;
        Id = id;
    }
*/

    public String getDiscon() {
        return Discon;
    }

    public void setDiscon(String discon) {
        Discon = discon;
    }

    public String getStok() {
        return Stok;
    }

    public void setStok(String stok) {
        Stok = stok;
    }

    public String getNopol() {
        return Nopol;
    }

    public void setNopol(String nopol) {
        Nopol = nopol;
    }

    public String getTahun() {
        return Tahun;
    }

    public void setTahun(String tahun) {
        Tahun = tahun;
    }

    public String getSilinder() {
        return Silinder;
    }

    public void setSilinder(String silinder) {
        Silinder = silinder;
    }

    public String getDeskripsion() {
        return Deskripsion;
    }

    public void setDeskripsion(String deskripsion) {
        Deskripsion = deskripsion;
    }

    public String getHarga() {
        return Harga;
    }

    public void setHarga(String harga) {
        Harga = harga;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
