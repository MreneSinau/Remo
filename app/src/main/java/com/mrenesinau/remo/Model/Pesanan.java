package com.mrenesinau.remo.Model;

/**
 * Created by adipu on 11/01/2018.
 */

public class Pesanan {

    private String Harga;
    private String NamaMobil;
    private String Nopoll;
    private String IdPes;
    private String Jmlh;
    private String NamaUser;
    private String NoHpUser;
    private String Email;
    private String Tanggal;
    private String Awal;
    private String Ahir;
    private String Durasi;
    private String NamaRental;
    private String Diskon;
    private String Status;

    public Pesanan() {
    }

    public Pesanan(String harga, String namaMobil, String nopoll, String idPes, String jmlh, String namaUser, String noHpUser, String email, String tanggal, String awal, String ahir, String durasi, String namaRental, String diskon, String status) {
        Harga = harga;
        NamaMobil = namaMobil;
        Nopoll = nopoll;
        IdPes = idPes;
        Jmlh = jmlh;
        NamaUser = namaUser;
        NoHpUser = noHpUser;
        Email = email;
        Tanggal = tanggal;
        Awal = awal;
        Ahir = ahir;
        Durasi = durasi;
        NamaRental = namaRental;
        Diskon = diskon;
        Status = status;
    }

    public String getHarga() {
        return Harga;
    }

    public void setHarga(String harga) {
        Harga = harga;
    }

    public String getNamaMobil() {
        return NamaMobil;
    }

    public void setNamaMobil(String namaMobil) {
        NamaMobil = namaMobil;
    }

    public String getNopoll() {
        return Nopoll;
    }

    public void setNopoll(String nopoll) {
        Nopoll = nopoll;
    }

    public String getIdPes() {
        return IdPes;
    }

    public void setIdPes(String idPes) {
        IdPes = idPes;
    }

    public String getJmlh() {
        return Jmlh;
    }

    public void setJmlh(String jmlh) {
        Jmlh = jmlh;
    }

    public String getNamaUser() {
        return NamaUser;
    }

    public void setNamaUser(String namaUser) {
        NamaUser = namaUser;
    }

    public String getNoHpUser() {
        return NoHpUser;
    }

    public void setNoHpUser(String noHpUser) {
        NoHpUser = noHpUser;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getTanggal() {
        return Tanggal;
    }

    public void setTanggal(String tanggal) {
        Tanggal = tanggal;
    }

    public String getAwal() {
        return Awal;
    }

    public void setAwal(String awal) {
        Awal = awal;
    }

    public String getAhir() {
        return Ahir;
    }

    public void setAhir(String ahir) {
        Ahir = ahir;
    }

    public String getDurasi() {
        return Durasi;
    }

    public void setDurasi(String durasi) {
        Durasi = durasi;
    }

    public String getNamaRental() {
        return NamaRental;
    }

    public void setNamaRental(String namaRental) {
        NamaRental = namaRental;
    }

    public String getDiskon() {
        return Diskon;
    }

    public void setDiskon(String diskon) {
        Diskon = diskon;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
