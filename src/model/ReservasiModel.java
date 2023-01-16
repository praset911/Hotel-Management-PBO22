package model;

import entity.KamarEntity;
import entity.ReservasiEntity;
import entity.TamuEntity;
import utils.DateString;

import java.util.ArrayList;

public class ReservasiModel {


    public static ArrayList<ReservasiEntity> ArrayReservasi = new ArrayList<>();

    public static void checkIn(TamuEntity tamu, KamarEntity kamar, int malam) {
        ReservasiEntity checkIn = new ReservasiEntity(tamu, kamar, malam);
        ArrayReservasi.add(checkIn);
    }

    public static void checkOut(int indexReservasi) {
        ReservasiEntity reservasi = ArrayReservasi.get(indexReservasi);
        reservasi.setTanggalCheckOut(DateString.now());
        ArrayReservasi.set(indexReservasi, reservasi);
    }


    public static int cariReservasibyKodeKamar(String kodeKamar) {
        int i = -1;
        for (ReservasiEntity reservasi : ArrayReservasi) {
            i += 1;
            if ((reservasi.kamar.getKodeKamar().equals(kodeKamar)) && (reservasi.TanggalCheckOut.equals("Belum CheckOut"))) {
                if (!reservasi.kamar.getStatus()) {
                    return i;
                }
            }
        }
        return -1;
    }
}
