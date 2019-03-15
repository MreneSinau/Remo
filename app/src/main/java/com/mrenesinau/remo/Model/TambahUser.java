package com.mrenesinau.remo.Model;

/**
 * Created by adipu on 09/01/2018.
 */

public class TambahUser {
    private String Name;
    private String Password;
    private String Alamat;
    private String Jkel;
    private String Namalengkap;
    private String Nohp;

    public TambahUser () {

    }

    public TambahUser(String name, String password, String alamat, String jkel, String namalengkap, String nohp) {
        Name = name;
        Password = password;
        Alamat = alamat;
        Jkel = jkel;
        Namalengkap = namalengkap;
        Nohp = nohp;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String alamat) {
        Alamat = alamat;
    }

    public String getJkel() {
        return Jkel;
    }

    public void setJkel(String jkel) {
        Jkel = jkel;
    }

    public String getNamalengkap() {
        return Namalengkap;
    }

    public void setNamalengkap(String namalengkap) {
        Namalengkap = namalengkap;
    }

    public String getNohp() {
        return Nohp;
    }

    public void setNohp(String nohp) {
        Nohp = nohp;
    }
}
