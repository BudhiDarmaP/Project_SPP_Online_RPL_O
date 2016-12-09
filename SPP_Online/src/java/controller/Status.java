/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pembayaran;
import model.Siswa;
import model.Tagihan;

/**
 *
 * @author budhidarmap
 */

@WebServlet(name = "Status", urlPatterns = {"/Status"})
public class Status extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nis = request.getParameter("nis");
        try {
            //Check kelengkapan input
            if (nis.equals("")) {
                throw new Exception("NIS Belum Terisi");
            }
            try {
                int formatNIS = Integer.parseInt(nis);
            } catch (Exception ej) {
                throw new Exception("Format NIS Salah");
            }
        } catch (Exception e) {
            returnError(request, response, e);
        }
        DatabaseManager db = new DatabaseManager();
        try {
            //Check kelengkapan input
            
            //Cek siswa ada di database
            Siswa[] s = Siswa.getListSiswa();
            for (int i = 0; i < s.length; i++) {
                if (nis.equals(s[i].getNis()) && s.length > i) {
                    
                    
//                    String Nama = "Nama\t:\t"+s[i].getNama();
//                    String NIS = "<p>NIS\t:\t"+s[i].getNis()+"</p>";
                    Tagihan tg = Tagihan.getTagihan(nis);
                    Pembayaran[] pb = Pembayaran.getPembayaran(nis);
                    Tagihan[] t = Tagihan.getListTagihan(nis);
                    String hasil;
                    String daftar = "<table><tr><th>Bulan"
                            + "<th>Jumlah Tagihan</tr>"
                            + "<tr><td>" + tg.getBulan_tagihan() + "<td>"
                            + tg.getJumlah_pembayaran() + "</tr></table>";
                    if (tg.isStatus_pembayaran()) {
                        hasil = "Sudah bayar";
                    } else {
                        hasil = "Belum bayar";
                    }
                    this.tampil(request, response, /*NIS + Nama +*/daftar + hasil);
                } else if (!nis.equals(s[i].getNis()) && s.length - 1 == i) {
                    throw new Exception("NIS Tidak Ditemukan");
                }
            }
        } catch (Exception e) {
            returnError(request, response, e);
        }
    }

    public void daftar(String nis) {
        DatabaseManager db = new DatabaseManager();

    }

    public void returnError(HttpServletRequest request, HttpServletResponse response, Exception e) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        request.setAttribute("error", e.getMessage());
        dispatcher = request.getRequestDispatcher("error.jsp");
        dispatcher.forward(request, response);
    }

    public void tampil(HttpServletRequest request, HttpServletResponse response, String information) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        request.setAttribute("info", information);
        dispatcher = request.getRequestDispatcher("info.jsp");
        dispatcher.forward(request, response);
    }

}
