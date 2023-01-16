package GUI.admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KelolaKamarFrame extends JFrame {

    KelolaKamarFrame(){
        super("Menu Kelola Kamar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setLocation(808,352);
        setSize(319,448);

        JLabel label = new JLabel("Kelola Kamar");
        label.setFont(new Font("Serif",Font.BOLD,22));
        label.setBounds(85,28,135,27);

        JButton tambah = new JButton("Tambah Kamar");
        tambah.setFont(new Font("Serif",Font.BOLD,18));
        tambah.setBounds(62,68,179,45);

        JButton lihat = new JButton("Lihat Data Kamar");
        lihat.setFont(new Font("Serif",Font.BOLD,18));
        lihat.setBounds(62,131,179,45);

        JButton update = new JButton("Update Kamar");
        update.setFont(new Font("Serif",Font.BOLD,18));
        update.setBounds(62,194,179,45);

        JButton delete = new JButton("Delete Kamar");
        delete.setFont(new Font("Serif",Font.BOLD,18));
        delete.setBounds(62,257,179,45);

        JButton back = new JButton("BACK");
        back.setFont(new Font("Serif",Font.BOLD,18));
        back.setBounds(62,320,179,45);

        add(label);
        add(tambah);
        add(lihat);
        add(update);
        add(delete);
        add(back);


        setVisible(true);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AdminMenuFrame();
            }
        });

        tambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new TambahKamar();
            }
        });

        lihat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LihatKamarFrame();
            }
        });

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new UpdateKamarFrame();
            }
        });

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new HapusKamarFrame();
            }
        });
    }

}
