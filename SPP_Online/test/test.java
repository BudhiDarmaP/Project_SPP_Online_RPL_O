
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
        //tagihan test
        Tagihan[] test = Tagihan.getListTagihan("14001");
        for(Tagihan temp:test){
            System.out.println(temp.getNis()+","+temp.getId_tagihan()+","+temp.getJumlah_pembayaran());
        }
    }
}
