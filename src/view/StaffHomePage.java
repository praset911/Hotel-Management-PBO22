package view;

import entity.KamarEntity;
import model.StaffModel;
import java.util.Scanner;
import controller.LoginController;
import model.KamarModel;

public class StaffHomePage {

    LoginController authentication = new LoginController();
    Scanner input = new Scanner(System.in);

    public void pageStaff(){
        int pilih;
        do {
            System.out.println("""
                                ==<MENU STAFF>==
                                1.Register Account
                                2.Data Kamar
                                3.Back""");
            System.out.print("INPUT : ");
            pilih = input.nextInt();
            input.nextLine();
            System.out.println();
            switch (pilih) {
                case 1 -> menuLoginAdmin();
                case 2 -> loginMenu();
            }
        }while(pilih!=3);
    }


    private void menuLoginAdmin(){
        String nik,password;
        boolean status = false;
        System.out.println("==<LOGIN ADMIN>==");
        System.out.print("NIK       :");
        nik=input.nextLine();
        System.out.print("Password  :");
        password=input.nextLine();
        status = authentication.loginAdmin(nik,password);

        if(status){
            System.out.println();
            registerAccount();
            System.out.println();
        }
        else{
            gagalLogin();
            menuLoginAdmin();
        }
    }

    private void registerAccount(){
        Scanner input = new Scanner(System.in);
        System.out.println("==<REGISTER MENU>==");
        System.out.print("Masukkan Nama     : ");
        String nama = input.nextLine();
        System.out.print("Masukkan NIK      : ");
        String nik = input.nextLine();
        System.out.print("Masukkan Alamat   : ");
        String alamat = input.nextLine();
        System.out.print("Masukkan No.Telp  : ");
        String telp = input.nextLine();
        System.out.print("Masukkan Password : ");
        String password = input.nextLine();
        StaffModel.addAccount(nama,nik,alamat,telp,password);
        System.out.println("AKUN <"+nama+"> BERHASIL DITAMBAHKAN\n");
    }

    private void gagalLogin(){
        System.out.println("NIP atau Password salah !");
    }

    private void loginMenu(){
        loginStaff();
        menuStaffLogin();
    }

    public void loginStaff(){
        String nip,password;
        boolean status = false;
        System.out.println("==LOGIN STAFF==");
        System.out.print("NIP       :");
        nip=input.nextLine();
        System.out.print("Password  :");
        password=input.nextLine();
        status = authentication.login(nip,password);

        if(status){
            System.out.println("Selamat Datang "+ authentication.getStaffLogged().getNamaLengkap());
            System.out.println();
            System.out.println();
        }
        else{
            gagalLogin();
            System.out.println();
            loginStaff();
        }
    }

    private void menuStaffLogin(){
        int pilihan;
        do {
            System.out.println("=========<Menu Staff>=========");
            System.out.println("1.Tambah Kamar");
            System.out.println("2.Lihat Kamar");
            System.out.println("3.Hapus Kamar");
            System.out.println("4.Edit Kamar");
            System.out.println("5.Back");
            System.out.print("INPUT : ");
            pilihan = input.nextInt();
            input.nextLine();
            switch (pilihan) {
                case 1 -> menuTambahDataKamar();
                case 2 -> KamarModel.lihatDataKamar();
                case 3 -> menuHapusDataKamar();
                case 4 -> menuEditDataKamar();
            }
            System.out.println("===============================");
            System.out.println();
        }while(pilihan!=5);
    }

    
  
    private void menuTambahDataKamar() {
        String kode;
        String jenis;
        int hargaKamar;
        boolean status = true;
        System.out.print("KODE KAMAR      : ");
        kode = input.nextLine();
        System.out.print("JENIS KAMAR    : ");
        jenis = input.nextLine();
        System.out.print("HARGA PER MALAM: ");
        hargaKamar = input.nextInt();
        input.nextLine();
        System.out.println("BERHASIL MENAMBAHKAN DATA KAMAR ! ");
        KamarModel.addDataKamar(kode, jenis, hargaKamar, status);
    }

    private void menuHapusDataKamar() {
        String kodeKamar;
        System.out.println("========<HAPUS-DATA>========");
        System.out.println();
        System.out.print("KODE KAMAR YANG AKAN DIHAPUS : ");
        kodeKamar = input.nextLine();
        KamarEntity kamarCari = KamarModel.cariDataKamar(kodeKamar);
        if (kamarCari != null) {
            KamarModel.hapusDataKamar(kamarCari);
            System.out.println("DATA <" + kamarCari.getKodeKamar() + "> BERHASIL DIHAPUS");
            System.out.println();
            System.out.println("===========================");
        } else {
            System.out.println("DATA TIDAK DITEMUKAN !");
            System.out.println();
            System.out.println("===========================");
        }
    }

    private void menuEditDataKamar() {
        Scanner input = new Scanner(System.in);
        String kodeReplace, kodeBaru, jenisBaru;
        int hargaBaru;
        boolean status = true;
        System.out.println("========<EDIT-DATA>========");
        System.out.println();
        System.out.print("KODE KAMAR YANG DIGANTI :");
        kodeReplace = input.nextLine();
        KamarEntity kamarCari = KamarModel.cariDataKamar(kodeReplace);
        if (kamarCari.getStatus() == false) {
            System.out.println("Kamar Masih Dipakai");
        } else {
            if (kamarCari != null) {
                System.out.print("KODE KAMAR BARU   :");
                kodeBaru = input.nextLine();
                System.out.print("JENIS KAMAR BARU  :");
                jenisBaru = input.nextLine();
                System.out.print("HARGA KAMAR BARU  :");
                hargaBaru = input.nextInt();
                input.nextLine();
                kamarCari.setKodeKamar(kodeBaru);
                kamarCari.setJenisKamar(jenisBaru);
                kamarCari.setHargaPerMalam(hargaBaru);
                kamarCari.setStatus(status);
//                KamarModel.editDataKamar(kamarCari);
                System.out.println("DATA <"+kamarCari.getKodeKamar()+"> BERHASIL DITAMBAHKAN !");
                System.out.println();
                System.out.println("==========================");
                System.out.println();
            } else {
                System.out.println("DATA TIDAK DITEMUKAN !");
                System.out.println();
                System.out.println("===========================");
            }
        }

    }
}
