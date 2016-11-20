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

/**
 *
 * @author Michael Donny Kusuma
 */
@WebServlet(name = "VerifikasiPembayaran", urlPatterns = {"/VerifikasiPembayaran"})
public class VerifikasiPembayaran extends HttpServlet {
    DatabaseManager db = new DatabaseManager();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nis = request.getParameter("nis");
        String nama = request.getParameter("nama");
        String jenis = request.getParameter("jenis");
        String tanggal = request.getParameter("tanggal");
        String jumlahP = request.getParameter("jumlah");
        double jumlah = 0;
        
        //Check inputan
        try{
            //Check kelengkapan input
            if (nis.isEmpty() || nama.isEmpty() || jenis.isEmpty() || tanggal.isEmpty() || jumlahP.isEmpty()) {
                throw new Exception("data belum lengkap");
            }
            //Check jumlah pembayaran
            try{
                jumlah = Double.parseDouble(jumlahP);
            }
            catch(Exception ej){
                throw new Exception("Jumlah salah");
            }
            //Check tanggal
            try{
                if (Integer.parseInt(tanggal.substring(0,2))>31 ||
                        Integer.parseInt(tanggal.substring(3,5))>12 ||
                        Integer.parseInt(tanggal.substring(6))<2000){
                    throw new Exception("Format tanggal salah");
                }
            }
            catch(Exception et){
                throw new Exception("Format tanggal salah");
            }
            if (!(tanggal.charAt(2)=='-' && tanggal.charAt(5)=='-')) {
                throw new Exception("Format tanggal salah");
            }
        }
        catch(Exception e){
            returnError(request, response, e);
        }
        
        
        //Membaca list data pembayaran dari tabel pembayaran
        Pembayaran p[] = db.getListPembayaran(tanggal);
        for (int i = 0; i < p.length; i++) {
            if (
                    p[i].getNis().replaceAll("\\s+","").equalsIgnoreCase(nis.replaceAll("\\s+","")) // bandingkan nis tanpa whitespace dan uppercase
                    && p[i].getJumlahPembayaran()==jumlah // bandingkan jumlah pembayaran
                    && p[i].getJenisPembayaran().replaceAll("\\s+","").equalsIgnoreCase(jenis.replaceAll("\\s+","")) // bandingkan jenis pembayaran
                    ) 
            {
                 //update status bayar tagihan menjadi sudah bayar
                this.tampil(request, response, "Pembayaran Terverifikasi");
            }
        }
        this.returnError(request, response, new Exception("Gagal Verifikasi"));
        
       
        
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
