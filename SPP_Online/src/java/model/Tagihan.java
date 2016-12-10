/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class Tagihan {

    private String id_tagihan;
    private String nis;
    private String pembayaran_terakhir;
    private int bulan_tagihan;
    private boolean status_pembayaran;
    private double jumlah_pembayaran;

    public boolean isStatus_pembayaran() {
        return status_pembayaran;
    }

    public void setStatus_pembayaran(boolean status_pembayaran) {
        this.status_pembayaran = status_pembayaran;
    }

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

    public int getBulan_tagihan() {
        return bulan_tagihan;
    }

    public void setBulan_tagihan(int bulan_tagihan) {
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

    public static void simpanTagihan(Tagihan t) {
        String text = null;
        Connection conn = null;
        PreparedStatement ps = null;
        conn = DatabaseManager.getDBConnection();
        try {
            
            ps = conn.prepareCall("INSERT INTO RPL_TAGIHAN VALUES(?,?,?,?,?)");
            ps.setString(1, t.getId_tagihan());
            ps.setString(2, t.getNis());
            ps.setInt(3, t.getBulan_tagihan());
            ps.setBoolean(4, t.status_pembayaran);
            ps.setDouble(5, t.getJumlah_pembayaran());

            ps.executeUpdate();
            conn.commit();
            text = "Data berhasil ditambahkan di tabel tagihan";

        } catch (SQLException ex) {
        } finally {
            try {
                ps.close();
                conn.close();
            } catch (SQLException ex) {
            }
        }

    }

    public static Tagihan[] getListTagihan(String nis) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        conn = DatabaseManager.getDBConnection();
        Tagihan tg[] = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT COUNT (*) "
                    + "TOTAL FROM RPL_TAGIHAN WHERE (NIS = '" + nis + "'"
                    + "AND STATUS_PEMBAYARAN=0)");
            rs.next();
            tg = new Tagihan[rs.getInt(1)];
            rs = st.executeQuery("SELECT *"
                    + "FROM RPL_TAGIHAN WHERE (NIS = '" + nis + "'"
                    + "AND STATUS_PEMBAYARAN=0)");
            int index = 0;
            while (rs.next()) {
                tg[index] = new Tagihan();
                tg[index].setId_tagihan(rs.getString(1));
                tg[index].setNis(rs.getString(2));
                tg[index].setBulan_tagihan(rs.getInt(3));
                tg[index].setStatus_pembayaran(rs.getBoolean(4));
                tg[index].setJumlah_pembayaran(rs.getDouble(5));
                index++;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                rs.close();
                st.close();
                conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return tg;
    }
    
    public static Tagihan[] getListStatusTagihan(String nis) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        conn = DatabaseManager.getDBConnection();
        Tagihan tg[] = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT COUNT (*) "
                    + "TOTAL FROM RPL_TAGIHAN WHERE NIS = '" + nis + "' ORDER BY BULAN_TAGIHAN ASC");
            rs.next();
            tg = new Tagihan[rs.getInt(1)];
            rs = st.executeQuery("SELECT *"
                    + "FROM RPL_TAGIHAN WHERE NIS = '" + nis + "' ORDER BY BULAN_TAGIHAN ASC");
            int index = 0;
            while (rs.next()) {
                tg[index] = new Tagihan();
                tg[index].setId_tagihan(rs.getString(1));
                tg[index].setNis(rs.getString(2));
                tg[index].setBulan_tagihan(rs.getInt(3));
                tg[index].setStatus_pembayaran(rs.getBoolean(4));
                tg[index].setJumlah_pembayaran(rs.getDouble(5));
                index++;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                rs.close();
                st.close();
                conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return tg;
    }

    public static Tagihan getTagihan(String nis) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        conn = DatabaseManager.getDBConnection();
        Tagihan tg = new Tagihan();
        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT *"
                    + "FROM RPL_TAGIHAN WHERE NIS = '" + nis + "'");
            rs.next();
            tg.setId_tagihan(rs.getString(1));
            tg.setNis(rs.getString(2));
            tg.setBulan_tagihan(rs.getInt(3));
            tg.setStatus_pembayaran(rs.getBoolean(4));
            tg.setJumlah_pembayaran(rs.getDouble(5));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                rs.close();
                st.close();
                conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return tg;
    }

    public static String verifikasiSukses(String nis, int bulan_tagihan) {
        String text = null;
        Connection conn = null;
        PreparedStatement ps = null;
        Statement st = null;
        ResultSet rs = null;
        conn = DatabaseManager.getDBConnection();
        try {
            ps = conn.prepareCall("UPDATE RPL_TAGIHAN SET STATUS_PEMBAYARAN=? WHERE NIS=? AND BULAN_TAGIHAN=?");
            ps.setBoolean(1, true);
            ps.setString(2, nis);
            ps.setInt(3, bulan_tagihan);
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {

        } finally {
            try {
                ps.close();
                conn.close();
            } catch (SQLException ex) {

            }
        }
        return text;
    }
}
