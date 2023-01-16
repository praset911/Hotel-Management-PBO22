package GUI;

import GUI.admin.AdminLoginFrame;
import GUI.staff.StaffLoginFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePageFrame extends JFrame {

    public HomePageFrame(){
        super("Program Hotel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setSize(726,989);

        JLabel logo = new JLabel();
        logo.setIcon(new ImageIcon("D:\\TUGAS1\\hotel.png"));
        logo.setBounds(205,206,334,415);

        JLabel label = new JLabel("HOTEL");
        label.setBounds(240,65,262,97);
        label.setFont(new Font("Serif",Font.BOLD,70));

        JLabel labelLogin = new JLabel("LOGIN");
        labelLogin.setBounds(263,651,200,73);
        labelLogin.setFont(new Font("Serif",Font.BOLD,60));

        JButton staff = new JButton("STAFF");
        staff.setBounds(417,754,223,96);
        staff.setFont(new Font ("Serif",Font.PLAIN,30));

        JButton admin = new JButton("ADMIN");
        admin.setBounds(80,754,223,96);
        admin.setFont(new Font ("Serif",Font.PLAIN,30));

        add(admin);
        add(staff);
        add(labelLogin);
        add(label);
        add(logo);

        setVisible(true);

        staff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new StaffLoginFrame();

            }
        });
        admin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AdminLoginFrame();
            }
        });
    }

}
