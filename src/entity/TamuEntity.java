package entity;

public class TamuEntity extends UserEntity {

    public TamuEntity(String nama_tamu, String nik, String telp, String alamat)
    {
        super(nama_tamu,nik,alamat,telp);
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

}
