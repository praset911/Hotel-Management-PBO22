package GUI.admin;

import entity.KamarEntity;
import model.KamarModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateKamarFrame extends JFrame{

    UpdateKamarFrame(){
        super("Update Kamar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setSize(662,335);

        JLabel label = new JLabel("Update Kamar");
        label.setFont(new Font("Serif",Font.BOLD,30));
        label.setBounds(281,16,204,36);

        JLabel kodeLama = new JLabel("Kode Kamar Lama");
        kodeLama.setFont(new Font("Serif",Font.BOLD,20));
        kodeLama.setBounds(20,66,172,24);

        JLabel kodeBaru = new JLabel("Kode Baru");
        kodeBaru.setFont(new Font("Serif",Font.BOLD,20));
        kodeBaru.setBounds(20,102,98,24);

        JLabel jenisBaru = new JLabel("Jenis Baru");
        jenisBaru.setFont(new Font("Serif",Font.BOLD,20));
        jenisBaru.setBounds(20,138,99,24);

        JLabel hargaBaru = new JLabel("Harga Baru");
        hargaBaru.setFont(new Font("Serif",Font.BOLD,20));
        hargaBaru.setBounds(20,174,106,24);

        JTextField kodelamaTF = new JTextField();
        kodelamaTF.setFont(new Font("Serif",Font.PLAIN,18));
        kodelamaTF.setBounds(204,66,418,24);

        JTextField kodeBaruTF = new JTextField();
        kodeBaruTF.setFont(new Font("Serif",Font.PLAIN,18));
        kodeBaruTF.setBounds(204,102,418,24);

        JTextField jenisBaruTF = new JTextField();
        jenisBaruTF.setFont(new Font("Serif",Font.PLAIN,18));
        jenisBaruTF.setBounds(204,138,418,24);

        JTextField hargaBaruTF = new JTextField();
        hargaBaruTF.setFont(new Font("Serif",Font.PLAIN,18));
        hargaBaruTF.setBounds(204,174,418,24);

        JButton back = new JButton("BACK");
        back.setFont(new Font("Serif",Font.BOLD,16));
        back.setBounds(17,229,79,35);

        JButton confirm = new JButton("CONFIRM");
        confirm.setFont(new Font("Serif",Font.BOLD,16));
        confirm.setBounds(502,229,120,35);

        add(label);
        add(kodeLama);
        add(kodeBaru);
        add(jenisBaru);
        add(hargaBaru);
        add(kodelamaTF);
        add(kodeBaruTF);
        add(jenisBaruTF);
        add(hargaBaruTF);
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
                String kodeLama = kodelamaTF.getText();
                String kodeBaru = kodeBaruTF.getText();
                String jenisBaru = jenisBaruTF.getText();
                int hargaBaru = Integer.parseInt(hargaBaruTF.getText());
                KamarEntity kamarCari = KamarModel.cariDataKamar(kodeLama);
                if(kamarCari!=null){
                    if(kamarCari.getStatus()){
                        kamarCari.setKodeKamar(kodeBaru);
                        kamarCari.setJenisKamar(jenisBaru);
                        kamarCari.setHargaPerMalam(hargaBaru);
                        kamarCari.setStatus(true);
                        JOptionPane.showMessageDialog(null,"Kamar <"+kodeBaru+"> Berhasil Di tambahkan","Success",JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                        new UpdateKamarFrame();
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Kamar masih dipakai","Warning",JOptionPane.WARNING_MESSAGE);
                        dispose();
                        new UpdateKamarFrame();
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"Kamar <"+kodeLama+"> Tidak Ditemukan","Warning",JOptionPane.WARNING_MESSAGE);
                    dispose();
                    new UpdateKamarFrame();
                }
            }
        });
    }

}
