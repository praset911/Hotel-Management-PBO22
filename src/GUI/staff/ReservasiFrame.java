package GUI.staff;

import entity.ReservasiEntity;
import model.ReservasiModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReservasiFrame extends JFrame {


    ReservasiFrame(){
        super("Reservasi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setSize(1104,488);

        JLabel label = new JLabel("List Reservasi");
        label.setFont(new Font("Serif",Font.BOLD,40));
        label.setBounds(414,45,262,48);

        JTable dataKamar = new JTable();
        TableModel model = createTableModel();
        dataKamar.setModel(model);

        JScrollPane scroll = new JScrollPane(dataKamar);
        scroll.setBounds(32,114,1026,297);

        JButton back = new JButton("BACK");
        back.setBounds(28,24,98,43);

        add(scroll);
        add(label);
        add(back);
        setVisible(true);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new StaffMenuFrame();
            }
        });
    }

    private TableModel createTableModel(){
        DefaultTableModel dataKamar = new DefaultTableModel();
        Object[] kolom = {"NO","KodeKamar","JenisKamar","NIK","Nama","No.Telp","CheckIn","Malam","CheckOut"};
        dataKamar.setColumnIdentifiers(kolom);
        int i =0;
        for (ReservasiEntity reservasi : ReservasiModel.ArrayReservasi) {
            Object[] data = new String[] {
                    String.valueOf(i+1),
                    reservasi.kamar.getKodeKamar(),
                    reservasi.kamar.getJenisKamar(),
                    reservasi.tamu.getNik(),
                    reservasi.tamu.getNamaLengkap(),
                    reservasi.tamu.getTelp(),
                    reservasi.TanggalCheckIn,
                    String.valueOf(reservasi.malam),
                    reservasi.TanggalCheckOut,
            };
            i++;
            dataKamar.addRow(data);
        }
        return dataKamar;
    }

}
