package GUI.admin;

import GUI.admin.KelolaKamarFrame;
import model.KamarModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LihatKamarFrame extends JFrame {


    LihatKamarFrame(){
        super("Lihat Kamar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setSize(843,488);

        JLabel label = new JLabel("List Kamar");
        label.setFont(new Font("Serif",Font.BOLD,40));
        label.setBounds(314,45,200,48);

        JTable dataKamar = new JTable();
        TableModel model = createTableModel();
        dataKamar.setModel(model);

        JScrollPane scroll = new JScrollPane(dataKamar);
        scroll.setBounds(28,114,772,297);

        JButton back = new JButton("BACK");
        back.setBounds(28,24,98,43);

        add(scroll);
        add(label);
        add(back);
        setVisible(true);
        dataKamar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = dataKamar.getSelectedRow();
                String selectedId = dataKamar.getValueAt(i,0).toString();

            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new KelolaKamarFrame();
            }
        });
    }

    private TableModel createTableModel(){
        DefaultTableModel dataKamar = new DefaultTableModel();
        Object[] kolom = {"NO","KodeKamar","JenisKamar","HargaPerMalam","Status"};
        dataKamar.setColumnIdentifiers(kolom);
        int size = KamarModel.ArrayKamar.size();
        for(int i=0;i<size;i++){
            Object[] data = new Object[5];
            data[0]=i+1;
            data[1]=KamarModel.ArrayKamar.get(i).getKodeKamar();
            data[2]=KamarModel.ArrayKamar.get(i).getJenisKamar();
            data[3]=KamarModel.ArrayKamar.get(i).getHargaPerMalam();
            data[4]=KamarModel.ArrayKamar.get(i).getStatus();

            dataKamar.addRow(data);
        }
        return dataKamar;
    }


}
