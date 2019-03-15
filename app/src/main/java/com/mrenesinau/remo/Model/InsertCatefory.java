package com.mrenesinau.remo.Model;

/**
 * Created by adipu on 14/01/2018.
 */

public class InsertCatefory extends Category {
    private String Nama;
    private String Image;

    public InsertCatefory() {
    }

    public InsertCatefory(String nama, String image) {
        Nama = nama;
        Image = image;
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
