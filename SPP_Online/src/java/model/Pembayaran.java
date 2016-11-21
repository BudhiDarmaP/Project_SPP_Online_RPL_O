package model;

/**
 *
 * @author Michael Donny Kusuma
 */
public class Pembayaran {
    private String ID;
    private String waktuPembayaran;
    private String noRekening;
    private double jumlahPembayaran;
    private String beritaAcara;
    private String nis;
    private String jenisPembayaran;
    private String status;
    private int bulanTagihan;

    public int getBulanTagihan() {
        return bulanTagihan;
    }

    public void setBulanTagihan(int bulanTagihan) {
        this.bulanTagihan = bulanTagihan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getWaktuPembayaran() {
        return waktuPembayaran;
    }

    public void setWaktuPembayaran(String waktuPembayaran) {
        this.waktuPembayaran = waktuPembayaran;
    }

    public String getNoRekening() {
        return noRekening;
    }

    public void setNoRekening(String noRekening) {
        this.noRekening = noRekening;
    }

    public double getJumlahPembayaran() {
        return jumlahPembayaran;
    }

    public void setJumlahPembayaran(double jumlahPembayaran) {
        this.jumlahPembayaran = jumlahPembayaran;
    }

    public String getBeritaAcara() {
        return beritaAcara;
    }

    public void setBeritaAcara(String beritaAcara) {
        this.beritaAcara = beritaAcara;
    }

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public String getJenisPembayaran() {
        return jenisPembayaran;
    }

    public void setJenisPembayaran(String jenisPembayaran) {
        this.jenisPembayaran = jenisPembayaran;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}