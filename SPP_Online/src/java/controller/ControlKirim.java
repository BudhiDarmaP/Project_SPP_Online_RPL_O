/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Siswa;
import model.Tagihan;

/**
 *
 * @author Alicia Destriani S
 */
@WebServlet(name = "ControlKirim", urlPatterns = {"/ControlKirim"})
public class ControlKirim extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DatabaseManager db = new DatabaseManager();
        String timeStamp = new SimpleDateFormat("YYMM").format(Calendar.getInstance().getTime());

        /* TODO output your page here. You may use following sample code. */
        //Siswa[] s = Siswa.getListSiswa();
        String email[] = Siswa.getListEmail();
        //Tagihan tgh = new Tagihan();
        String pesan = null;

        for (int i = 0; i < email.length; i++) {
            String to = email[i];
            String subject = "PERINGATAN PEMBAYARAN SPP";
            String msg = "REMINDER!!!\nSPP anda bulan "+timeStamp.substring(2)+" belum terbayar.\nTerima Kasih\nSMA Sanata Dharma";
            final String from = "semarmesam2020@gmail.com";
            final String password = "Ceksatu23";

            Transport transport;
            MimeMessage message;

            Properties props = new Properties();
            props.setProperty("mail.transport.protocol", "smtp");
            props.setProperty("mail.host", "smtp.gmail.com");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
            props.put("mail.debug", "true");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.socketFactory.fallback", "false");

            Session session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(from, password);
                }
            });

            try {
                //session.setDebug(true);  
                transport = session.getTransport();
                InternetAddress addressFrom = new InternetAddress(from);

                message = new MimeMessage(session);
                message.setSender(addressFrom);
                message.setSubject(subject);
                message.setContent(msg, "text/plain");
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

                transport.connect();
                Transport.send(message);
                pesan = "Pesan berhasil dikirim ke " + String.valueOf(email.length+1) +" orang";
                transport.close();
            } catch (Exception e) {
            }
        }
                this.tampil(request, response, pesan);
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
