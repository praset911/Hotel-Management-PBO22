package model;

import entity.KamarEntity;

import java.util.ArrayList;

public class KamarModel {


    public static ArrayList<KamarEntity> ArrayKamar = new ArrayList<>();

    public static void initialKamar(){
        KamarEntity kamarAwal = new KamarEntity("001","VIP",500000,true);
        ArrayKamar.add(kamarAwal);

    }

    public static void lihatDataKamar(){
        for (KamarEntity datakamar : ArrayKamar) {
            System.out.println("KODE KAMAR                    : " + datakamar.getKodeKamar());
            System.out.println("JENIS KAMAR                   : " + datakamar.getJenisKamar());
            System.out.println("HARGA PER MALAM               : " + datakamar.getHargaPerMalam());
            System.out.print("STATUS                        : ");
            if(datakamar.getStatus()){
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
        KamarEntity kamar = new KamarEntity(kodeKamar,jenisKamar,harga,status);
        ArrayKamar.add(kamar);
    }

    public static KamarEntity cariDataKamar(String kodeKamar){
        for (KamarEntity datakamar : ArrayKamar){
            if(datakamar.getKodeKamar().equals(kodeKamar)){
                return datakamar;
            }
        }
        return null;
    }

    public static void hapusDataKamar(KamarEntity kamarCari){
        ArrayKamar.remove(kamarCari);
    }

}
