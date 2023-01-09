package entity;

public abstract class UserEntity {

    protected String namaLengkap,alamat,telp,nik;

    public UserEntity(String namaLengkap, String nik, String alamat, String telp){
        this.namaLengkap=namaLengkap;
        this.alamat=alamat;
        this.telp=telp;
        this.nik=nik;
    }

    public abstract String getNamaLengkap();

    public abstract String getAlamat();

    public abstract String getTelp();

    public abstract String getNik();

    public void Display()
    {
        System.out.println(" Nama       = " + namaLengkap);
        System.out.println(" Nik        = " + nik);
        System.out.println(" No.Telp    = " + telp);
        System.out.println(" Alamat     = " + alamat);
    }

}
