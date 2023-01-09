package model;

import entity.Kamar;
import entity.Reservasi;
import entity.Staff;
import entity.Tamu;
import utils.DateString;

import java.util.ArrayList;

public class Hotel {
    public static ArrayList<Staff> ArrayStaffAdmin = new ArrayList<>();
    public static ArrayList<Staff> ArrayStaff= new ArrayList<>();
    public static ArrayList<Kamar> ArrayKamar = new ArrayList<>();
    public static ArrayList<Reservasi> ArrayReservasi = new ArrayList<>();

    public static void initialData(){
        initialStaff();
        initialKamar();
    }
    public static void initialStaff(){
        Staff adminAktif = new Staff("Prasetya","074133","Medokan","08123456789","123");
        ArrayStaffAdmin.add(adminAktif);
        Staff staffAktif = new Staff("Prasetya Kusuma Atmaja","07413","Surabaya","03123456","123");
        ArrayStaff.add(staffAktif);
    }
    public static ArrayList<Staff> allStaff(){
        return ArrayStaff;
    }
    public static ArrayList<Staff> allAdmin(){
        return ArrayStaffAdmin;
    }
    public static void initialKamar(){
        Kamar kamarAwal = new Kamar("001","VIP",500000,true);
        ArrayKamar.add(kamarAwal);

    }

    public static void lihatDataKamar(){
        for (Kamar datakamar : Hotel.ArrayKamar) {
            System.out.println("KODE KAMAR                    : " + datakamar.getKodeKamar());
            System.out.println("JENIS KAMAR                   : " + datakamar.getJenisKamar());
            System.out.println("HARGA PER MALAM               : " + datakamar.getHargaPerMalam());
            System.out.print("STATUS                        : ");
            if(datakamar.getStatus()==true){
                System.out.println("TERSEDIA");
                System.out.println();
            }
            else{
                System.out.println("RESERVED");
                System.out.println();
            }
        }
    }

    public static void addDataKamar(String kodeKamar,String jenisKamar,int harga,boolean status){
        Kamar kamar = new Kamar(kodeKamar,jenisKamar,harga,status);
        Hotel.ArrayKamar.add(kamar);
    }

    public static Kamar cariDataKamar(String kodeKamar){
        for (Kamar datakamar : Hotel.ArrayKamar){
            if(datakamar.getKodeKamar().equals(kodeKamar)){
                return datakamar;
            }
        }
        return null;
    }

    public static void hapusDataKamar(Kamar kamarCari){
        Hotel.ArrayKamar.remove(kamarCari);
    }

    public static int indexDataKamar(Kamar indexkamar){
        int index = Hotel.ArrayKamar.indexOf(indexkamar);
        return index;
    }

    public static void editDataKamar(Kamar kamarCari) {
        int index = indexDataKamar(kamarCari);
        Hotel.ArrayKamar.get(index).setKodeKamar(kamarCari.getKodeKamar());
        Hotel.ArrayKamar.get(index).setJenisKamar(kamarCari.getJenisKamar());
    }

    public static void checkIn(Tamu tamu, Kamar kamar, int malam) {
        Reservasi checkIn = new Reservasi(tamu, kamar, malam);
        ArrayReservasi.add(checkIn);
    }

    public static void checkOut(int indexReservasi) {
        Reservasi reservasi = ArrayReservasi.get(indexReservasi);
        reservasi.setTanggalCheckOut(DateString.now());
        Kamar kamar = reservasi.kamar;

        ArrayReservasi.set(indexReservasi, reservasi);
    }

    public static int cariReservasibyKodeKamar(String kodeKamar) {
        int i = -1;
        for (Reservasi reservasi : ArrayReservasi) {
            i += 1;
            if (reservasi.kamar.getKodeKamar().equals(kodeKamar)) {
                if (!reservasi.kamar.getStatus()) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void addAccount(String nama,String nik,String alamat,String telp,String password){
        Staff staff = new Staff(nama,nik,alamat,telp,password);
        Hotel.ArrayStaff.add(staff);
    }

}
