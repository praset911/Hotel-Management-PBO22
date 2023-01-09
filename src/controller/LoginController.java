package controller;

import entity.StaffEntity;
import model.StaffModel;
import view.HomePage;
import java.util.ArrayList;

public class LoginController {
    public StaffEntity staffLogin;

    public void toView(){
        new HomePage();
    }
    public StaffEntity getStaffLogged(){
        return staffLogin;
    }

    public boolean login(String nik, String password){
        ArrayList<StaffEntity> staffList = StaffModel.allStaff();
        for(StaffEntity staff : staffList) {
            if (((staff.getNik().equals(nik))) && (staff.getPassword().equals(password))) {
                staffLogin = staff;
                return true;
            }
        }
        return false;
    }

    public boolean loginAdmin(String nik, String password){
        ArrayList<StaffEntity> adminList = StaffModel.allAdmin();
        for(StaffEntity staff : adminList) {
            if (((staff.getNik().equals(nik))) && (staff.getPassword().equals(password))) {
                staffLogin = staff;
                return true;
            }
        }
        return false;
    }

}

