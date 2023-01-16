package GUI.admin;

import entity.KamarEntity;
import model.KamarModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


    public class HapusKamarFrame extends JFrame {

        HapusKamarFrame(){
            super("Hapus Kamar");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setResizable(false);
            setLayout(null);
            setSize(662,239);

            JLabel label = new JLabel("Hapus Kamar");
            label.setFont(new Font("Serif",Font.BOLD,30));
            label.setBounds(281,13,222,42);

            JLabel kode = new JLabel("Kode Kamar ");
            kode.setFont(new Font("Serif",Font.BOLD,20));
            kode.setBounds(20,63,142,30);

            JTextField kodeTF = new JTextField();
            kodeTF.setFont(new Font("Serif",Font.BOLD,18));
            kodeTF.setBounds(204,66,418,30);

            JButton back = new JButton("BACK");
            back.setFont(new Font("Serif",Font.BOLD,16));
            back.setBounds(17,113,79,35);

            JButton confirm = new JButton("CONFIRM");
            confirm.setFont(new Font("Serif",Font.BOLD,16));
            confirm.setBounds(502,113,120,35);

            add(label);
            add(kode);
            add(kodeTF);
            add(back);
            add(confirm);

            setVisible(true);

            back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new KelolaKamarFrame();
                }
            });

            confirm.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String kode = kodeTF.getText();
                    KamarEntity kamarCari = KamarModel.cariDataKamar(kode);
                    if(kamarCari!=null){
                       KamarModel.hapusDataKamar(kamarCari);
                       JOptionPane.showMessageDialog(null,"Kamar <"+kode+"> Berhasil Dihapus","Success",JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                        new HapusKamarFrame();
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Kamar <"+kode+"> Tidak Ditemukan","Warning",JOptionPane.WARNING_MESSAGE);
                        dispose();
                        new HapusKamarFrame();
                    }
                }
            });
        }


    }

