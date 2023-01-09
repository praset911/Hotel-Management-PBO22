package entity;

public class User {

    protected String namaLengkap,alamat,telp,nik;

    public User(String namaLengkap,String nik,String alamat, String telp){
        this.namaLengkap=namaLengkap;
        this.alamat=alamat;
        this.telp=telp;
        this.nik=nik;
    }

    public String getNamaLengkap() {
        return this.namaLengkap;
    }

    public String getAlamat() {
        return this.alamat;
    }

    public String getTelp() {
        return this.telp;
    }

    public String getNik(){
        return this.nik;
    }

    public void Display()
    {
        System.out.println(" Nama       = " + namaLengkap);
        System.out.println(" Nik        = " + nik);
        System.out.println(" No.Telp    = " + telp);
        System.out.println(" Alamat     = " + alamat);
    }

}
