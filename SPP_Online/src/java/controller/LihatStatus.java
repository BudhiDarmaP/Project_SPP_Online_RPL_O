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
import model.Tagihan;

/**
 *
 * @author budhidarmap
 */
@WebServlet(name = "LihatStatus", urlPatterns = {"/LihatStatus"})
public class LihatStatus extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DatabaseManager db = new DatabaseManager();
        Tagihan tg = db.getTagihan(request.getParameter("nis"));
        Pembayaran[] pb = db.getPembayaran(request.getParameter("nis"));
        Tagihan[] t = db.getListTagihan(request.getParameter("nis"));
        String hasil;
        String daftar = null;
        System.out.println(tg.isStatus_pembayaran());
        if (tg.isStatus_pembayaran()) {
            hasil = "Sudah bayar";
//            "<style>
//table {
//    font-family: arial, sans-serif;
//    border-collapse: collapse;
//    width: 100%;
//}
//
//td, th {
//    border: 1px solid #dddddd;
//    text-align: left;
//    padding: 8px;
//}
//
//tr:nth-child(even) {
//    background-color: #dddddd;
//}
//</style>
//<table>
//  <tr>
//    <th>NIS</th>
//    <th>BULAN TAGIHAN</th>
//    <th>WAKTU PEMBAYARAN</th>
//    <th>STATUS PEMBAYARAN</th>
//  </tr>
//  <tr>
//    <td></td>
//    <td></td>
//    <td></td>
//  </tr>
//</table>"
//            for (int i = 0; i < t.length; i++) {
//            daftar="<table></table>";
//        }
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
