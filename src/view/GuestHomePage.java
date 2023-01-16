package view;

import entity.KamarEntity;
import entity.ReservasiEntity;
import entity.TamuEntity;
import model.ReservasiModel;
import java.util.Scanner;
import model.KamarModel;

public class GuestHomePage {

    public void loginGuest(){
        StaffHomePage login = new StaffHomePage();
        login.loginStaff();
        menuTamu();
    }

    Scanner input = new Scanner(System.in);
    private void menuTamu(){
        int pilih;
        do {
            System.out.println("=========<Menu Tamu>=========");
            System.out.println("1.Check In");
            System.out.println("2.Check Out");
            System.out.println("3.Daftar Reservasi");
            System.out.println("4.Back");
            System.out.print("INPUT : ");
            pilih = input.nextInt();
            input.nextLine();
            System.out.println();
            switch(pilih){
                case 1 ->checkIn();
                case 2 ->checkOut();
                case 3 ->dataReservasi();
            }

            System.out.println("==============================");
        }while (pilih!=4);
    }

    private void checkIn(){
        System.out.println();
        System.out.print("NAMA PEMESAN                  : ");
        String nama = input.nextLine();
        System.out.print("NIP PEMESAN                   : ");
        String nip = input.nextLine();
        System.out.print("NO TELP PEMESAN               : ");
        String telp = input.nextLine();
        System.out.print("ALAMAT PEMESAN                : ");
        String alamat = input.nextLine();
        KamarModel.lihatDataKamar();
        System.out.print("KODE KAMAR YANG AKAN DI PESAN : ");
        String kodeKamar = input.nextLine();
        KamarEntity kamarcari = KamarModel.cariDataKamar(kodeKamar);
        if(kamarcari!=null){
            if(!kamarcari.getStatus()){
                System.out.println("KAMAR SUDAH DI PESAN,PILIH KAMAR LAIN !");
                menuTamu();
            }
            else{
                System.out.println("Menginap Berapa Malam       : ");
                int malam = input.nextInt();
                input.nextLine();
                kamarcari.setStatus(false);
                TamuEntity tamu = new TamuEntity(nama,nip,telp,alamat);
                ReservasiModel.checkIn(tamu, kamarcari, malam);
                System.out.println("BERHASIL MEMESAN KAMAR !");
            }
        }
        else{
            System.out.println("KAMAR TIDAK DITEMUKAN");
            System.out.println();
            checkIn();
        }

    }

    private void checkOut() {
        System.out.println("==========<CHECK OUT>==========");
        String kodeKamar;
        System.out.print("Masukan Kode Kamar  : ");
        kodeKamar = input.nextLine();
        KamarEntity kamarCari = KamarModel.cariDataKamar(kodeKamar);
        int indexReservasi = ReservasiModel.cariReservasibyKodeKamar(kodeKamar);
        if (indexReservasi > -1) {
            kamarCari.setStatus(true);
            ReservasiModel.checkOut(indexReservasi);
            System.out.println("BERHASIL CHECK OUT");

        } else {
            System.out.println("Data Tidak Ditemukan !");
        }
    }
    private void dataReservasi() {
        for (ReservasiEntity reservasi : ReservasiModel.ArrayReservasi) {
            System.out.println("==============================================");
            System.out.println("Kode Kamar      : " + reservasi.kamar.getKodeKamar());
            System.out.println("Jenis Kamar     : " + reservasi.kamar.getJenisKamar());
            System.out.println("----------------------------------------------");
            System.out.println("NIK Tamu        : " + reservasi.tamu.getNik());
            System.out.println("Nama Tamu       : " + reservasi.tamu.getNamaLengkap());
            System.out.println("No Telp Tamu    : " + reservasi.tamu.getTelp());
            System.out.println("----------------------------------------------");
            System.out.println("Tanggal CheckIn : " + reservasi.TanggalCheckIn);
            System.out.println("Malam           : " + reservasi.malam);
            System.out.println("Tanggal CheckOut: " + reservasi.TanggalCheckOut);
            System.out.println("==============================================");
        }
    }

    
}
