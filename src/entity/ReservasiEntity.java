package entity;

import utils.DateString;

public class ReservasiEntity {
    public TamuEntity tamu;
    public KamarEntity kamar;
    public int malam;
    public String TanggalCheckIn;
    public String TanggalCheckOut = "Belum CheckOut";

    public ReservasiEntity(TamuEntity tamu, KamarEntity kamar, int malam)
    {
        this.tamu=tamu;
        this.kamar=kamar;
        this.malam=malam;
        this.TanggalCheckIn= DateString.now();
    }
    public void setTanggalCheckOut(String tanggalCheckOut) {
        this.TanggalCheckOut = tanggalCheckOut;
    }
}
