package com.mrenesinau.remo.Model;

import java.io.Serializable;

/**
 * Created by adipu on 04/01/2018.
 */

public class DataMaps implements Serializable{

    private double latitude,longitude;
    private String email;
    private String nama;
    private String alamat;
    private String nomer;
    private String informasi;
    private String id;
    private String web;

    public DataMaps() {
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNomer() {
        return nomer;
    }

    public void setNomer(String nomer) {
        this.nomer = nomer;
    }

    public String getInformasi() {
        return informasi;
    }

    public void setInformasi(String informasi) {
        this.informasi = informasi;
    }

    @Override
    public String toString(){
        return ""+id+"\n"+
                ""+nama+"\n"+
                ""+alamat+"\n"+
                ""+nomer+"\n"+
                ""+informasi+"\n"+
                ""+latitude+"\n"+
                ""+web+"\n"+
                ""+longitude;
    }

    public DataMaps(String webb, String idd, String em,String nm,String al,String no,String in, double la,double lo){
        id=idd;
        email=em;
        web=webb;
        nama=nm;
        alamat=al;
        nomer=no;
        informasi=in;
        latitude=la;
        longitude=lo;
    }


}
