package com.mrenesinau.remo.Model;

/**
 * Created by adipu on 14/01/2018.
 */

public class Order {

    private String IdCat;
    private String IdPes;
    private String Jumlah;
    private String Harga;
    private String Diskon;
    private String Tanggal;
    private String Awal;
    private String Ahir;
    private String Durasi;
    private String Email;
    private String NamaMobil;
    private String NamaRental;
    private String NamaUser;
    private String NoHpUser;
    private String Nopoll;
    private String Status;

    public Order() {
    }

    public Order(String idCat, String idPes, String jumlah, String harga, String diskon, String tanggal, String awal, String ahir, String durasi, String email, String namaMobil, String namaRental, String namaUser, String noHpUser, String nopoll, String status) {
        IdCat = idCat;
        IdPes = idPes;
        Jumlah = jumlah;
        Harga = harga;
        Diskon = diskon;
        Tanggal = tanggal;
        Awal = awal;
        Ahir = ahir;
        Durasi = durasi;
        Email = email;
        NamaMobil = namaMobil;
        NamaRental = namaRental;
        NamaUser = namaUser;
        NoHpUser = noHpUser;
        Nopoll = nopoll;
        Status = status;
    }

    public String getIdCat() {
        return IdCat;
    }

    public void setIdCat(String idCat) {
        IdCat = idCat;
    }

    public String getIdPes() {
        return IdPes;
    }

    public void setIdPes(String idPes) {
        IdPes = idPes;
    }

    public String getJumlah() {
        return Jumlah;
    }

    public void setJumlah(String jumlah) {
        Jumlah = jumlah;
    }

    public String getHarga() {
        return Harga;
    }

    public void setHarga(String harga) {
        Harga = harga;
    }

    public String getDiskon() {
        return Diskon;
    }

    public void setDiskon(String diskon) {
        Diskon = diskon;
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

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getNamaMobil() {
        return NamaMobil;
    }

    public void setNamaMobil(String namaMobil) {
        NamaMobil = namaMobil;
    }

    public String getNamaRental() {
        return NamaRental;
    }

    public void setNamaRental(String namaRental) {
        NamaRental = namaRental;
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

    public String getNopoll() {
        return Nopoll;
    }

    public void setNopoll(String nopoll) {
        Nopoll = nopoll;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
