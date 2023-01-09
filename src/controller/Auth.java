package controller;

import entity.Staff;
import model.Hotel;
import view.HomePage;
import java.util.ArrayList;

public class Auth {
    public Staff staffLogin;

    public void toView(){
        new HomePage();
    }
    public Staff getStaffLogged(){
        return staffLogin;
    }

    public boolean login(String nik, String password){
        ArrayList<Staff> staffList = Hotel.allStaff();
        for(Staff staff : staffList) {
            if (((staff.getNik().equals(nik))) && (staff.getPassword().equals(password))) {
                staffLogin = staff;
                return true;
            }
        }
        return false;
    }

    public boolean loginAdmin(String nik, String password){
        ArrayList<Staff> adminList = Hotel.allAdmin();
        for(Staff staff : adminList) {
            if (((staff.getNik().equals(nik))) && (staff.getPassword().equals(password))) {
                staffLogin = staff;
                return true;
            }
        }
        return false;
    }

}

