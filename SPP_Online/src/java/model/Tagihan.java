/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Michael Donny Kusuma
 */
public class Tagihan {
    private String id_tagihan;
    private String nis;
    private String jenis_pembayaran;
    private String pembayaran_terakhir;
    private String bulan_tagihan;
    private boolean status_pembayaran;

    public boolean isStatus_pembayaran() {
        return status_pembayaran;
    }

    public void setStatus_pembayaran(boolean status_pembayaran) {
        this.status_pembayaran = status_pembayaran;
    }
    private double jumlah_pembayaran;

    public String getId_tagihan() {
        return id_tagihan;
    }

    public void setId_tagihan(String id_tagihan) {
        this.id_tagihan = id_tagihan;
    }

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public String getJenis_pembayaran() {
        return jenis_pembayaran;
    }

    public void setJenis_pembayaran(String jenis_pembayaran) {
        this.jenis_pembayaran = jenis_pembayaran;
    }


    public String getBulan_tagihan() {
        return bulan_tagihan;
    }

    public void setBulan_tagihan(String bulan_tagihan) {
        this.bulan_tagihan = bulan_tagihan;
    }
    
    public String getPembayaran_terakhir() {
        return pembayaran_terakhir;
    }

    public void setPembayaran_terakhir(String pembayaran_terakhir) {
        this.pembayaran_terakhir = pembayaran_terakhir;
    }

    public double getJumlah_pembayaran() {
        return jumlah_pembayaran;
    }

    public void setJumlah_pembayaran(double jumlah_pembayaran) {
        this.jumlah_pembayaran = jumlah_pembayaran;
    }  
}
