/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Siswa;
import model.Bank;
import java.util.Properties;
import java.util.TimerTask;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 *
 * @author Michael Donny Kusuma
 */
public class MengirimPemberitahuan extends TimerTask {

    @Override
    public void run() {
        DatabaseManager db = new DatabaseManager();
        
        //Meminta daftar email siswa dengan status pembayaran false dari database
        Siswa[] s = db.getListSiswa();
        String[] email = db.getEmail();
        
        for (int i = 0; i < s.length; i++) {
            email[i] = s[i].getEmail();
            System.out.println(email[i]);
            String to = email[i];
            String subject = "INFORMASI PEMBAYARAN SPP";
            String msg ="Status pembayaran SPP anda bulan ini masih belum terbayar";
            final String from ="semarmesam2020@gmail.com";
            final  String password ="Ceksatu23";

            Transport transport;
            MimeMessage message;

            Properties props = new Properties();  
            props.setProperty("mail.transport.protocol", "smtp");     
            props.setProperty("mail.host", "smtp.gmail.com");  
            props.put("mail.smtp.auth", "true");  
            props.put("mail.smtp.port", "465");  
            props.put("mail.debug", "true");  
            props.put("mail.smtp.socketFactory.port", "465");  
            props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
            props.put("mail.smtp.socketFactory.fallback", "false");  
            
            Session session = Session.getDefaultInstance(props,  
            new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {  
                return new PasswordAuthentication(from,password);  
                }  
            });  

            try{
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
                transport.close();
            }
            catch(Exception e){
            }
        }
    }
    
}
