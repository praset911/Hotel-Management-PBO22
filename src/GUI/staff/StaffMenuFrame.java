package GUI.staff;

import GUI.HomePageFrame;
import GUI.staff.CheckInFrame;
import GUI.staff.CheckOutFrame;
import GUI.staff.ReservasiFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StaffMenuFrame extends JFrame {

    public StaffMenuFrame(){
        super("STAFF");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setLocation(808,352);
        setSize(319,430);

        JLabel labelMenu = new JLabel("MENU STAFF");
        labelMenu.setFont(new Font("Serif",Font.BOLD,15));
        labelMenu.setBounds(107,52,110,18);

        JButton checkIn = new JButton("CheckIn");
        checkIn.setFont(new Font("Serif",Font.BOLD,17));
        checkIn.setBounds(83,100,140,45);

        JButton checkOut = new JButton("CheckOut");
        checkOut.setFont(new Font("Serif",Font.BOLD,17));
        checkOut.setBounds(83,165,140,45);

        JButton reservasi = new JButton("DaftarReservasi");
        reservasi.setFont(new Font("Serif",Font.BOLD,15));
        reservasi.setBounds(83,230,140,45);

        JButton back = new JButton("BACK");
        back.setFont(new Font("Serif",Font.BOLD,17));
        back.setBounds(83,295,140,45);

        add(labelMenu);
        add(back);
        add(reservasi);
        add(checkOut);
        add(checkIn);

        setVisible(true);

        checkIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new CheckInFrame();
            }
        });

        checkOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new CheckOutFrame();
            }
        });

        reservasi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ReservasiFrame();
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new HomePageFrame();
            }
        });
    }


}
