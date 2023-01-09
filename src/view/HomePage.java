package view;

import view.GuestHomePage;
import view.StaffHomePage;

import java.util.Scanner;
public class HomePage {
    Scanner input = new Scanner(System.in);
    StaffHomePage pageStaff = new StaffHomePage();
    GuestHomePage pageGuest = new GuestHomePage();

    public HomePage(){
        menu();
    }

    public void menu() {
        int pilihan;
        do {
            System.out.println("""
                    Hotel Prasetya
                    1.Staff
                    2.Tamu
                    3.EXIT""");
            System.out.print("INPUT : ");
            pilihan = input.nextInt();
            input.nextLine();
            System.out.println();
            switch (pilihan) {
                case 1  -> pageStaff.pageStaff();
                case 2  -> pageGuest.loginGuest();
                case 3  -> System.out.println("EXIT");
                default -> System.out.println("INVALID INPUT");

            }
        } while (pilihan!=3);

    }

}
