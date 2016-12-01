/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import model.Pembayaran;
import model.Tagihan;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.servlet.*;
import org.apache.commons.io.output.*;

/**
 *
 * @author Michael Donny Kusuma
 */
@WebServlet(name = "ControlPembayaran", urlPatterns = {"/ControlPembayaran"})
public class ControlPembayaran extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
        String timeStamp2 = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());

        Pembayaran p = new Pembayaran();
        DatabaseManager db = new DatabaseManager();

        //Menyimpan file ke dalam sistem
        File file;
        int maxFileSize = 5000 * 1024;
        int maxMemSize = 5000 * 1024;
        String filePath = "c:/Apache/";

        String contentType = request.getContentType();
        if (contentType.indexOf("multipart/form-data") >= 0) {

            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(maxMemSize);
            factory.setRepository(new File("c:\\temp"));
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setSizeMax(maxFileSize);
            try {
                List fileItems = upload.parseRequest(request);
                Iterator i = fileItems.iterator();

                while (i.hasNext()) {
                    FileItem fi = (FileItem) i.next();
                    if (!fi.isFormField()) {
                        if (fi.getName().contains(".csv")) {
                        String fieldName = fi.getFieldName();
                        String fileName = fi.getName();
                        boolean isInMemory = fi.isInMemory();
                        long sizeInBytes = fi.getSize();
                        file = new File(filePath + "DataPembayaran_" + timeStamp + ".csv");
                        fi.write(file);
                        }
                        else{
                            throw new Exception("Format File Salah");
                        }
                    }
                }
            } catch (Exception ex) {
                returnError(request, response, ex);
            }
        } else {
            Exception e = new Exception("no file uploaded");
            returnError(request, response, e);
        }
        //Membaca file dari dalam sistem
        String csvFile = filePath + "DataPembayaran_" + timeStamp + ".csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {
            br = new BufferedReader(new FileReader(csvFile));
            int counter = 1;
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] dataSet = line.split(cvsSplitBy);
                p.setID(timeStamp2 + "_" + counter);
                p.setWaktuPembayaran(dataSet[0]);
                p.setNoRekening(dataSet[1]);
                p.setJumlahPembayaran(Double.parseDouble(dataSet[2]));
                p.setNis(dataSet[3].substring(0, 5));
                p.setBulanTagihan(Integer.parseInt(dataSet[3].substring(6)));
                p.setJenisPembayaran("SPP");//poi
                //Membandingkan nis, jumlah, bulan pembayaran ke tagihan
                Tagihan[] t = Tagihan.getListTagihan(p.getNis());
                for (int i = 0; i < t.length; i++) {
                    if (t[i].getNis().equals(p.getNis())
                            && t[i].getJumlah_pembayaran() == p.getJumlahPembayaran()
                            && t[i].getBulan_tagihan() == p.getBulanTagihan())// bandingkan jumlah pembayaran
                    {
                //Masukan data pembayaran ke database
                        Pembayaran.simpanPembayaran(p);
                //update status pembayaran tagihan
                        t[i].verifikasiSukses(p.getNis(), p.getBulanTagihan());//update status bayar tagihan menjadi sudah bayar
                    }
                }
                counter++;
            }
            this.tampil(request, response, "Data Terverifikasi");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
//        }
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
