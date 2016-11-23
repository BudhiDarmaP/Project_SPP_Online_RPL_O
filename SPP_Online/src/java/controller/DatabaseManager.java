/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

//import Model.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Pembayaran;
import model.Siswa;
import model.Tagihan;

public class DatabaseManager {
    public static Connection getDBConnection() {
//        String host = "172.23.9.185"; //172.23.9.185
//        String port = "1521";
//        String db = "orcl"; //orcl
//        String usr = "MHS145314059"; //MHS145314059
//        String pwd = "ADSHPP29"; //ADSHPP29
        
        String host = "localhost"; //local
        String port = "1521";
        String db = "XE"; 
        String usr = "sia";
        String pwd = "sia";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Maaf driver class tidak ditemukan");
            System.out.println(ex.getMessage());
        }
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@" + host + ":" + port + ":" + db, usr, pwd);
        } catch (SQLException ex) {
            System.out.println("koneksi tidak berhasil");
            System.out.println(ex.getMessage());
        }

        if (conn != null) {
            System.out.println("Koneksi ke database terbentuk");
        } else {
            System.out.println("Koneksi gagal terbentuk");
        }
        return conn;
    }
}
