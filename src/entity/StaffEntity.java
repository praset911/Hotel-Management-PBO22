package entity;

public class StaffEntity extends UserEntity {

    public String password;
        return this.password;
    }

    @Override
    public String getNamaLengkap() {
        return namaLengkap;
    }

    @Override
    public String getAlamat() {
        return alamat;
    }

    @Override
    public String getTelp() {
        return telp;
    }

    @Override
    public String getNik() {
        return nik;
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
