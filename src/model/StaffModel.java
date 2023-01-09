package model;

import entity.StaffEntity;

import java.util.ArrayList;

public class StaffModel {
    public static ArrayList<StaffEntity> ArrayStaffAdmin = new ArrayList<>();
    public static ArrayList<StaffEntity> ArrayStaff= new ArrayList<>();

    public static void initialStaff(){
        StaffEntity adminAktif = new StaffEntity("Prasetya","074133","Medokan","08123456789","123");
        ArrayStaffAdmin.add(adminAktif);
        StaffEntity staffAktif = new StaffEntity("Prasetya Kusuma Atmaja","07413","Surabaya","03123456","123");
        ArrayStaff.add(staffAktif);
    }
    public static ArrayList<StaffEntity> allStaff(){
        return ArrayStaff;
    }
    public static ArrayList<StaffEntity> allAdmin(){
        return ArrayStaffAdmin;
    }


    public static void addAccount(String nama,String nik,String alamat,String telp,String password){
        StaffEntity staff = new StaffEntity(nama,nik,alamat,telp,password);
        StaffModel.ArrayStaff.add(staff);
    }

}
