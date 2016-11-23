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
        try {
            //Check kelengkapan input
            if (request.getParameter("nis").equals("")) {
                throw new Exception("NIS Belum Terisi");
            }
        } catch (Exception e) {
            returnError(request, response, e);
        }

        DatabaseManager db = new DatabaseManager();
        try {
            //Check kelengkapan input
            Siswa[] s = Siswa.getListSiswa();
            for (int i = 0; i < s.length;i++) {
                if (!request.getParameter("nis").equals(s[i].getNis())) {
                    throw new Exception("NIS Tidak Ditemukan");
                }
            }
        } catch (Exception e) {
            returnError(request, response, e);
        }
        Tagihan tg = Tagihan.getTagihan(request.getParameter("nis"));
        Pembayaran[] pb = Pembayaran.getPembayaran(request.getParameter("nis"));
        Tagihan[] t = Tagihan.getListTagihan(request.getParameter("nis"));
        String hasil;
        String daftar = null;
        System.out.println(tg.isStatus_pembayaran());
        if (tg.isStatus_pembayaran()) {
            hasil = "Sudah bayar";
        } else {
            hasil = "Belum bayar";
        }
        this.tampil(request, response, hasil);
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
