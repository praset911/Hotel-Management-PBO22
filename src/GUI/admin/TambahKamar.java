package GUI.admin;

import entity.KamarEntity;
import model.KamarModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TambahKamar extends JFrame {

    TambahKamar(){
        super("GUI.admin.TambahKamar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setSize(662,304);

        JLabel labelMenu = new JLabel("Tambah Kamar");
        labelMenu.setFont(new Font("Serif",Font.BOLD,27));
        labelMenu.setBounds(251,24,203,30);

        JLabel kode = new JLabel("KodeKamar");
        kode.setFont(new Font("Serif",Font.BOLD,20));
        kode.setBounds(20,66,116,24);

        JLabel jenis = new JLabel("JenisKamar");
        jenis.setFont(new Font("Serif",Font.BOLD,20));
        jenis.setBounds(20,102,116,24);

        JLabel harga = new JLabel("HargaPerMalam");
        harga.setFont(new Font("Serif",Font.BOLD,20));
        harga.setBounds(20,138,151,24);

        JTextField kodeTF = new JTextField();
        kodeTF.setFont(new Font("Serif",Font.PLAIN,18));
        kodeTF.setBounds(184,69,438,24);

        JTextField jenisTF = new JTextField();
        jenisTF.setFont(new Font("Serif",Font.PLAIN,18));
        jenisTF.setBounds(184,104,438,24);

        JTextField hargaTF = new JTextField();
        hargaTF.setFont(new Font("Serif",Font.PLAIN,18));
        hargaTF.setBounds(184,140,438,24);

        JButton back = new JButton("BACK");
        back.setFont(new Font("Serif",Font.PLAIN,15));
        back.setBounds(20,194,79,35);

        JButton confirm = new JButton("CONFIRM");
        confirm.setFont(new Font("Serif",Font.PLAIN,15));
        confirm.setBounds(502,194,120,35);

        add(labelMenu);
        add(kode);
        add(jenis);
        add(harga);
        add(kodeTF);
        add(jenisTF);
        add(hargaTF);
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
                String jenis = jenisTF.getText();
                int harga = Integer.parseInt(hargaTF.getText());
                KamarEntity kamaCari = KamarModel.cariDataKamar(kode);
                if(kamaCari!=null){
                    JOptionPane.showMessageDialog(null,"KODE KAMAR SUDAH TERDAFTAR!!!","Warning",JOptionPane.WARNING_MESSAGE);
                    dispose();
                    new TambahKamar();
                }
                else{
                    KamarModel.addDataKamar(kode,jenis,harga,true);
                    JOptionPane.showMessageDialog(null,"Berhasil menambahkan kamar dengan kode <"+kode+">","Success",JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    new TambahKamar();
                }

            }
        });

    }

}

