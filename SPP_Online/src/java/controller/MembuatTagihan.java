/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Siswa;
import model.Tagihan;

/**
 *
 * @author Michael Donny Kusuma
 * ID Tagihan
 * 1 Digit pertaman = jenis pembayaran
 * Digit 2 - 3 = tahun tagihan
 * Digit 4 - 5 = tanggal tagihan
 * Digit 6 - 10 = nis
 */
public class MembuatTagihan extends TimerTask {

    @Override
    public void run() {
        DatabaseManager db = new DatabaseManager();
        String timeStamp = new SimpleDateFormat("yyMM").format(Calendar.getInstance().getTime());
        PrintWriter pw;
        
        //Membaca daftar siswa dari database
        Siswa[] s = db.getListSiswa();
        
        //Membuat daftar tagihan
        Tagihan[] t = new Tagihan[s.length];
        for (int i = 0; i < s.length; i++) {
            t[i] = new Tagihan();
            t[i].setId_tagihan("1"+timeStamp+s[i].getNis());
            t[i].setNis(s[i].getNis());
            t[i].setJenis_pembayaran("SPP");
            t[i].setPembayaran_terakhir("20-"+timeStamp.substring(2)+"-20"+timeStamp.substring(0,2));
            t[i].setStatus_pembayaran(false);
            t[i].setJumlah_pembayaran(500_000);
            db.simpanTagihan(t[i]);
        }
        
        //Menyimpan daftar tagihan ke file
        StringBuilder sb = new StringBuilder();
        sb.append("NIS");
        sb.append(',');
        sb.append("JENIS PEMBAYARAN");
        sb.append(',');
        sb.append("JUMLAH PEMBAYARAN");
        sb.append("\r\n");
        for (int i = 0; i < t.length; i++) {
            sb.append(t[i].getNis());
            sb.append(',');
            sb.append(t[i].getJenis_pembayaran());
            sb.append(',');
            sb.append(t[i].getJumlah_pembayaran());
            sb.append("\r\n");
        }
        
        // Menyimpan file ke daftar_tagihan.csv
        try {
            pw = new PrintWriter(new File("E:\\PROJECT\\SistemPembayaranUangSekolah\\web\\file\\daftar_tagihan.csv"));               
            pw.write(sb.toString());
            pw.close();
            System.out.println("done!");  
                
        } catch (FileNotFoundException ex) {
                
        }
    }
    
}
