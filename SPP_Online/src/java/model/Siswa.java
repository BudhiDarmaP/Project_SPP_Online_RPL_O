/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.DatabaseManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Michael Donny Kusuma
 */
public class Siswa {
    @Autowired private String nis;
    @Autowired private String nama;
    @Autowired private String email;

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public static Siswa getSiswa(String nis) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        conn = DatabaseManager.getDBConnection();
        Siswa s = new Siswa();
        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM RPL_SISWA");
            rs.next();
            rs = st.executeQuery("SELECT NIS, NAMA, EMAIL FROM RPL_SISWA "
                    + "WHERE NIS='"+nis+"'");
            int index = 0;
            while (rs.next()) {
                s.setNis(rs.getString(1));
                s.setNama(rs.getString(2));
                s.setEmail(rs.getString(3));
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
        return s;
    }
    public static Siswa[] getListSiswa() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        conn = DatabaseManager.getDBConnection();
        Siswa s[] = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT count(NIS) FROM RPL_SISWA");
            rs.next();
            s = new Siswa[rs.getInt(1)];
            rs = st.executeQuery("SELECT NIS, NAMA, EMAIL FROM RPL_SISWA");
            int index = 0;
            while (rs.next()) {
                s[index] = new Siswa();
                s[index].setNis(rs.getString(1));
                s[index].setNama(rs.getString(2));
                s[index].setEmail(rs.getString(3));
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
        return s;
    }
    public static String[] getListEmail() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        conn = DatabaseManager.getDBConnection();
        String s[] = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT COUNT (email) FROM RPL_SISWA WHERE NIS IN(SELECT NIS FROM RPL_TAGIHAN WHERE STATUS_PEMBAYARAN=0)");
            rs.next();
            s = new String[rs.getInt(1)];
            rs = st.executeQuery("SELECT email FROM RPL_SISWA WHERE NIS IN(SELECT NIS FROM RPL_TAGIHAN WHERE STATUS_PEMBAYARAN=0)");
            int index = 0;
            while (rs.next()) {
                s[index] = rs.getString(1);
                index++;
            }
        } catch (SQLException ex) {
        } finally {
            try {
                rs.close();
                st.close();
                conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return s;
    }
}
