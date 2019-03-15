package com.mrenesinau.remo.Model;

/**
 * Created by adipu on 01/01/2018.
 */

public class Mobil {

    private String Nama, Image, Deskripsion, Harga, Discon, MenuId, Stok;


    public Mobil() {
    }

    public Mobil(String nama, String image, String deskripsion, String harga, String discon, String menuId, String stok) {
        Nama = nama;
        Image = image;
        Deskripsion = deskripsion;
        Harga = harga;
        Discon = discon;
        MenuId = menuId;
        Stok = stok;
    }

    public String getStok() {
        return Stok;
    }

    public void setStok(String stok) {
        Stok = stok;
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

    public String getDiscon() {
        return Discon;
    }

    public void setDiscon(String discon) {
        Discon = discon;
    }

    public String getMenuId() {
        return MenuId;
    }

    public void setMenuId(String menuId) {
        MenuId = menuId;
    }
}
