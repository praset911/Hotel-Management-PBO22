package entity;

public class Staff extends User {

    public String password;

    public Staff(String nama_staff,String nik,String alamat, String telp,String password)
    {
        super(nama_staff,nik,alamat,telp);
        this.password=password;
    }

    public String getPassword(){
        return this.password;
    }

    public void Display()
    {
            System.out.println(" Nama Staff = " + getNamaLengkap());
            System.out.println(" NIK        = " + getNik());
            System.out.println(" Alamat     = " + getAlamat());
            System.out.println(" No.Telp    = " + getTelp());
            System.out.println(" Password   = " + getPassword());
    }
}
