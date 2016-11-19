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
    
    public Connection getConnection(){
       String host = "172.23.9.185"; //172.23.9.185
       String port = "1521";
       String db = "orcl"; //orcl
       String usr = "MHS145314059"; //MHS145314059
       String pwd = "ADSHPP29"; //ADSHPP29
              try{
           Class.forName("oracle.jdbc.driver.OracleDriver");}
       catch (ClassNotFoundException ex){
           System.out.println("Maaf driver class tidak ditemukan");
           System.out.println(ex.getMessage());}
              Connection conn = null;
       try{
           conn = DriverManager.getConnection("jdbc:oracle:thin:@"+host+":"+port+":"+db, usr, pwd);
       }
       catch (SQLException ex){
           System.out.println("koneksi tidak berhasil");
           System.out.println(ex.getMessage());
       }
       
       if (conn!=null) {
           System.out.println("Koneksi ke database terbentuk");
       }
       else{
           System.out.println("Koneksi gagal terbentuk");
       }
       return conn;
    }
    
    public void simpanTagihan(Tagihan t){
       String text = null;
       Connection conn = null;
       PreparedStatement ps = null;       
       conn = this.getConnection();  
            try{
                int status = 0;
                if (t.isStatus_pembayaran()) {
                    status = 1;
                }
                ps = conn.prepareCall("INSERT INTO RPL_TAGIHAN VALUES(?,?,?,TO_DATE(?, 'DD-MM-YYYY'),?,?)");
                ps.setString(1, t.getId_tagihan());
                ps.setString(2, t.getNis());
                ps.setString(3, t.getJenis_pembayaran());
                ps.setString(4, t.getPembayaran_terakhir());
                ps.setInt(5, status);
                ps.setDouble(6, t.getJumlah_pembayaran());
                
                ps.executeUpdate();
                conn.commit();
                text = "Data berhasil ditambahkan di tabel tagihan";

            }
            catch(SQLException ex){
            }
            finally{
                try{
                    ps.close();
                    conn.close();}
                catch (SQLException ex){
                }
            }
       
    }
   
    public Siswa[] getListSiswa(){
       Connection conn = null;
       Statement st = null;
       ResultSet rs = null;
       conn = this.getConnection();
       Siswa s[] = null;
       try{
           st = conn.createStatement();
           rs = st.executeQuery("SELECT count(NIS) FROM RPL_SISWA");
           rs.next();
           s = new Siswa[rs.getInt(1)];
           rs = st.executeQuery("SELECT NIS, NAMA, EMAIL FROM RPL_SISWA");
           int index =0;
           while(rs.next()){
               s[index] = new Siswa();
               s[index].setNis(rs.getString(1));
               s[index].setNama(rs.getString(2));
               s[index].setEmail(rs.getString(3));
               index++;               
           }
       }
       catch (SQLException ex){
           System.out.println(ex.getMessage());     
       }
       finally{
           try{
               rs.close();
               st.close();
               conn.close();
           }
           catch (SQLException ex){
               System.out.println(ex.getMessage());
           }
       }
   return s;
   }
    
    public String[] getEmail(){
       Connection conn = null;
       Statement st = null;
       ResultSet rs = null;
       conn = this.getConnection();
       String s[] = null;
       try{
           st = conn.createStatement();
           rs = st.executeQuery("SELECT COUNT (email) FROM RPL_SISWA WHERE NIS IN(SELECT NIS FROM RPL_TAGIHAN WHERE STATUS_PEMBAYARAN=0)");
           rs.next();
           s = new String[rs.getInt(1)];
           rs = st.executeQuery("SELECT email FROM RPL_SISWA WHERE NIS IN(SELECT NIS FROM RPL_TAGIHAN WHERE STATUS_PEMBAYARAN=0)");
           int index =0;
           while(rs.next()){
               s[index] = rs.getString(1);
               index++;               
           }
       }
       catch (SQLException ex){         
       }
       finally{
           try{
               rs.close();
               st.close();
               conn.close();
           }
           catch (SQLException ex){
               System.out.println(ex.getMessage());
           }
       }
   return s;
   }
    
    public Tagihan[] getListTagihan(String nis, String tanggal){
       Connection conn = null;
       Statement st = null;
       ResultSet rs = null;
       conn = this.getConnection();
       Tagihan tg[] = null;
       try{
           st = conn.createStatement();
           rs = st.executeQuery("SELECT COUNT (*) "
                   + "TOTAL FROM RPL_TAGIHAN WHERE NIS = '"+nis+"' AND BULAN_TAGIHANTO_DATE("
                   + "'"+tanggal+"' , 'MM-YY'");
           rs.next();
           tg = new Tagihan[rs.getInt(1)];
           rs = st.executeQuery("SELECT ID, NIS, JENIS_PEMBAYARAN, PEMBAYARAN_TERAKHIR, BULAN_TAGIHAN, JUMLAH_PEMBAYARAN, STATUS"
                   + "FROM RPL_TAGIHAN WHERE NIS='"+nis+"'");
           int index =0;
           while(rs.next()){
               tg[index] = new Tagihan();
               tg[index].setId_tagihan(rs.getString(1));
               tg[index].setNis(rs.getString(2));
               tg[index].setJenis_pembayaran(rs.getString(3));
               tg[index].setPembayaran_terakhir(rs.getString(4));
               tg[index].setJumlah_pembayaran(rs.getDouble(5));
               tg[index].setStatus_pembayaran(rs.getBoolean(6));
               index++;               
           }
       }
       catch (SQLException ex){
           System.out.println(ex.getMessage());       
       }
       finally{
           try{
               rs.close();
               st.close();
               conn.close();
           }
           catch (SQLException ex){
               System.out.println(ex.getMessage());
           }
       }
   return tg;
   }
    
    public Pembayaran[] getListPembayaran(String tanggal){
       Connection conn = null;
       Statement st = null;
       ResultSet rs = null;
       conn = this.getConnection();
       Pembayaran pb[] = null;
       try{
           st = conn.createStatement();
           rs = st.executeQuery("SELECT COUNT (*) "
                   + "TOTAL FROM RPL_PEMBAYARAN WHERE TANGGAL_PEMBAYARAN = TO_DATE("
                   + "'"+tanggal+"' , 'DD-MM-YY')");
           rs.next();
           pb = new Pembayaran[rs.getInt(1)];
           rs = st.executeQuery("SELECT ID_PEMBAYARAN, NIS, NO_REKENING, JUMLAH_PEMBAYARAN, JENIS_PEMBAYARAN, TO_CHAR(TANGGAL_PEMBAYARAN, 'DD-MM-YYYY') "
                   + "FROM RPL_PEMBAYARAN WHERE TANGGAL_PEMBAYARAN = TO_DATE("
                   + "'"+tanggal+"' , 'DD-MM-YY')");
           int index =0;
           while(rs.next()){
               pb[index] = new Pembayaran();
               pb[index].setID(rs.getString(1));
               pb[index].setNis(rs.getString(2));
               pb[index].setNoRekening(rs.getString(3));
               pb[index].setJumlahPembayaran(rs.getInt(4));
               pb[index].setJenisPembayaran(rs.getString(5));
               pb[index].setWaktuPembayaran(rs.getString(6));
               index++;               
           }
       }
       catch (SQLException ex){
           System.out.println(ex.getMessage());       
       }
       finally{
           try{
               rs.close();
               st.close();
               conn.close();
           }
           catch (SQLException ex){
               System.out.println(ex.getMessage());
           }
       }
   return pb;
   }
    
    
    public void simpanPembayaran(Pembayaran p){
       String text = null;
       Connection conn = null;
       PreparedStatement ps = null;       
       conn = this.getConnection();  
       try{
               ps = conn.prepareCall("INSERT INTO RPL_PEMBAYARAN VALUES(?,?,?,?,?,?,TO_DATE(?, 'DD-MM-YYYY'))");
               ps.setString(1, p.getID());
               ps.setString(2, p.getNis());
               ps.setString(3, p.getNoRekening());
               ps.setDouble(4, p.getJumlahPembayaran());
               ps.setString(5, p.getJenisPembayaran());
               ps.setString(6, p.getStatus());
               ps.setString(7, p.getWaktuPembayaran());
               ps.executeUpdate();
               conn.commit();
               text = "Data sudah ditambahkan";
           
           
       }
       catch(SQLException ex){
       }
       finally{
           try{
               ps.close();
               conn.close();}
           catch (SQLException ex){
           }
       }
    }
    
    public String verifikasiSukses(String nis, String jenisPembayaran){
       String text = null;
       Connection conn = null;
       PreparedStatement ps = null; 
       Statement st = null;
       ResultSet rs = null;
       conn = this.getConnection();
       try{
           ps = conn.prepareCall("UPDATE RPL_TAGIHAN SET STATUS_PEMBAYARAN=? WHERE NIS=? AND JENIS_PEMBAYARAN=? ");
           ps.setInt(1, 1);
           ps.setString(2, nis);
           ps.setString(3, jenisPembayaran);
           ps.executeUpdate();
           conn.commit();
       }
       catch(SQLException ex){
            
       }
       finally{
           try{
               ps.close();
               conn.close();
           }
           catch (SQLException ex){
               
           }
       }
       return text;    
   }

}
