
import model.Pembayaran;
import model.Siswa;
import model.Tagihan;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author budhidarmap
 */
public class test {

    public static void main(String[] args) {
        
    //Test Siswa
//    String [] email=Siswa.getListEmail();
//        for (int i = 0; i < email.length; i++) {
//            System.out.println(email[i]);
//    }
//    Siswa[] s =Siswa.getListSiswa();
//    for (int i = 0; i < s.length; i++) {
//            System.out.println(s[i].getNis()+" "+s[i].getNama()+" "+s[i].getEmail());
//    }
}

//Test Pembayaran
//        Siswa[] s = Siswa.getListSiswa();
//        Pembayaran[] p = Pembayaran.getPembayaran("14001");
//        
//            System.out.println(p[i].getID() + "," + p[i].getNis() + ","
//                + p[i].getNoRekening() + "," + p[i].getJumlahPembayaran()
//                + "," + p[i].getJenisPembayaran() + "," + p[i].getWaktuPembayaran());
//        p.setID("20161127_1");
//        p.setWaktuPembayaran("27-Nov-16");
//        p.setNoRekening("44143157");
//        p.setJumlahPembayaran(500000);
//        p.setNis("14001");
//        p.setBulanTagihan(11);
//        p.setJenisPembayaran("SPP");
//        Pembayaran.simpanPembayaran(p);
//        Test Tagihan
//        Siswa [] s = Siswa.getListSiswa();
//        Tagihan[] t = new Tagihan[s.length];
//        for (int i = 0; i < s.length; i++) {
//            t[i] = new Tagihan();
//            t[i].setId_tagihan("11611" + s[i].getNis());
//            t[i].setNis(s[i].getNis());
//            t[i].setBulan_tagihan(11);
//            t[i].setStatus_pembayaran(false);
//            t[i].setJumlah_pembayaran(500000);
//            Tagihan.simpanTagihan(t[i]);
//        }
//        Tagihan test = Tagihan.getTagihan("14001");
//            System.out.println(test.getNis()+","+test.getBulan_tagihan()+","
//            +test.getJumlah_pembayaran()+","+test.isStatus_pembayaran());
//        Siswa siswa = Siswa.getSiswa("14001");
//        System.out.println(siswa.getNama());
//        Tagihan.verifikasiSukses("14001", 11);
//        Tagihan test = Tagihan.getTagihan("14001");
//        System.out.println(test.isStatus_pembayaran());
}
