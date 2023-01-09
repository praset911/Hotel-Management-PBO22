package entity;

import utils.DateString;

public class Reservasi {
    public Tamu tamu;
    public Kamar kamar;
    public int malam;
    public String TanggalCheckIn;
    public String TanggalCheckOut;

    public Reservasi(Tamu tamu, Kamar kamar, int malam)
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
