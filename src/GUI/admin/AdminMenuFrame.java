package GUI.admin;

import GUI.HomePageFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMenuFrame extends JFrame {

    AdminMenuFrame(){
        super("ADMIN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setLocation(808,352);
        setSize(319,430);

        JLabel labelMenu = new JLabel("MENU ADMIN");
        labelMenu.setFont(new Font("Serif",Font.BOLD,16));
        labelMenu.setBounds(98,65,110,18);

        JButton register = new JButton("RegistAccount");
        register.setFont(new Font("Serif",Font.BOLD,17));
        register.setBounds(77,122,150,45);

        JButton kamar = new JButton("KelolaKamar");
        kamar.setFont(new Font("Serif",Font.BOLD,17));
        kamar.setBounds(77,195,150,45);

        JButton back = new JButton("BACK");
        back.setFont(new Font("Serif",Font.BOLD,17));
        back.setBounds(77,268,150,45);

        add(labelMenu);
        add(register);
        add(kamar);
        add(back);

        setVisible(true);

        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new RegisterFrame();
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new HomePageFrame();
            }
        });

        kamar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new KelolaKamarFrame();
            }
        });
    }


}
