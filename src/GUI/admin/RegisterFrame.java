package GUI.admin;

import model.StaffModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterFrame extends JFrame {

    RegisterFrame(){
        super("Form Registrrasi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setSize(663,382);

        JLabel labelMenu = new JLabel("Register Account");
        labelMenu.setFont(new Font("Serif",Font.BOLD,27));
        labelMenu.setBounds(251,24,203,30);

        JLabel nama = new JLabel("Nama");
        nama.setFont(new Font("Serif",Font.BOLD,20));
        nama.setBounds(20,66,55,24);

        JLabel nik = new JLabel("NIK");
        nik.setFont(new Font("Serif",Font.BOLD,18));
        nik.setBounds(20,102,34,24);

        JLabel alamat = new JLabel("Alamat");
        alamat.setFont(new Font("Serif",Font.BOLD,20));
        alamat.setBounds(20,138,66,24);

        JLabel telp = new JLabel("No.Telp");
        telp.setFont(new Font("Serif",Font.BOLD,20));
        telp.setBounds(20,174,72,24);

        JLabel password = new JLabel("Password");
        password.setFont(new Font("Serif",Font.BOLD,20));
        password.setBounds(20,210,93,24);

        JTextField namaTF = new JTextField();
        namaTF.setFont(new Font("Serif",Font.PLAIN,18));
        namaTF.setBounds(127,69,495,24);

        JTextField nipTF = new JTextField();
        nipTF.setFont(new Font("Serif",Font.PLAIN,18));
        nipTF.setBounds(127,104,495,24);

        JTextField alamatTF = new JTextField();
        alamatTF.setFont(new Font("Serif",Font.PLAIN,18));
        alamatTF.setBounds(127,140,495,24);

        JTextField telpTF = new JTextField();
        telpTF.setFont(new Font("Serif",Font.PLAIN,18));
        telpTF.setBounds(127,177,495,24);

        JTextField passTF = new JTextField();
        passTF.setFont(new Font("Serif",Font.PLAIN,18));
        passTF.setBounds(127,212,495,24);

        JButton back = new JButton("BACK");
        back.setFont(new Font("Serif",Font.PLAIN,15));
        back.setBounds(20,264,79,35);

        JButton confirm = new JButton("CONFIRM");
        confirm.setFont(new Font("Serif",Font.PLAIN,15));
        confirm.setBounds(502,264,120,35);

        add(confirm);
        add(back);
        add(passTF);
        add(telpTF);
        add(alamatTF);
        add(nipTF);
        add(namaTF);
        add(telp);
        add(password);
        add(alamat);
        add(nik);
        add(labelMenu);
        add(nama);
        setVisible(true);

        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = namaTF.getText();
                String nip = nipTF.getText();
                String alamat = alamatTF.getText();
                String telp = telpTF.getText();
                String password = passTF.getText();
                int cariNip = StaffModel.cariDataStaff(nip);
                if(cariNip==1){
                    JOptionPane.showMessageDialog(null,"NIP SUDAH TERDAFTAR!!!","Warning",JOptionPane.WARNING_MESSAGE);
                    dispose();
                    new RegisterFrame();
                }
                else {
                    StaffModel.addAccount(nama, nip, alamat, telp, password);
                    JOptionPane.showMessageDialog(null, "Akun <" + nama + "> Berhasil Di Daftarkan", "Success", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    new RegisterFrame();
                }
            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AdminMenuFrame();
            }
        });
    }


}
