package model;

import controller.DatabaseManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Michael Donny Kusuma
 */
public class Pembayaran {
    private String ID;
    private String waktuPembayaran;
    private String noRekening;
    private double jumlahPembayaran;
    private String beritaAcara;
    private String nis;
    private String status;
    private int bulanTagihan;

    public int getBulanTagihan() {
        return bulanTagihan;
    }

    public void setBulanTagihan(int bulanTagihan) {
        this.bulanTagihan = bulanTagihan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getWaktuPembayaran() {
        return waktuPembayaran;
    }

    public void setWaktuPembayaran(String waktuPembayaran) {
        this.waktuPembayaran = waktuPembayaran;
    }

    public String getNoRekening() {
        return noRekening;
    }

    public void setNoRekening(String noRekening) {
        this.noRekening = noRekening;
    }

    public double getJumlahPembayaran() {
        return jumlahPembayaran;
    }

    public void setJumlahPembayaran(double jumlahPembayaran) {
        this.jumlahPembayaran = jumlahPembayaran;
    }

    public String getBeritaAcara() {
        return beritaAcara;
    }

    public void setBeritaAcara(String beritaAcara) {
        this.beritaAcara = beritaAcara;
    }

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    public static void simpanPembayaran(Pembayaran p) {
        String text = null;
        Connection conn = null;
        PreparedStatement ps = null;
        conn = DatabaseManager.getDBConnection();
        try {
            ps = conn.prepareCall("INSERT INTO RPL_PEMBAYARAN VALUES(?,?,?,?,TO_DATE(?, 'DD-MM-YYYY'))");
            ps.setString(1, p.getID());
            ps.setString(2, p.getNis());
            ps.setString(3, p.getNoRekening());
            ps.setDouble(4, p.getJumlahPembayaran());
            ps.setString(5, p.getWaktuPembayaran());
            ps.executeUpdate();
            conn.commit();
            text = "Data sudah ditambahkan";

        } catch (SQLException ex) {
        } finally {
            try {
                ps.close();
                conn.close();
            } catch (SQLException ex) {
            }
        }
    }
}