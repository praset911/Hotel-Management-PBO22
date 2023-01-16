package GUI.admin;

import GUI.HomePageFrame;
import controller.LoginController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLoginFrame extends JFrame {
    LoginController login = new LoginController();
    public AdminLoginFrame(){
        super("LoginForm");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setSize(987,459);
        setVisible(true);

        JLabel loginLabel = new JLabel("Login Admin");
        loginLabel.setBounds(323,69,470,88);
        loginLabel.setFont(new Font("Serif",Font.BOLD,80));

        JLabel userLabel = new JLabel("Username :");
        userLabel.setBounds(51,178,193,48);
        userLabel.setFont(new Font("Serif",Font.BOLD,35));

        JLabel passLabel = new JLabel("Password :");
        passLabel.setBounds(51,240,185,48);
        passLabel.setFont(new Font("Serif",Font.BOLD,35));

        JButton okButton = new JButton("OK");
        okButton.setBounds(835,178,111,117);
        okButton.setFont(new Font("Serif",Font.BOLD,30));

        JButton backButton = new JButton("BACK");
        backButton.setBounds(25,300,123,52);
        backButton.setFont(new Font("Serif",Font.ITALIC,20));

        JTextField userText = new JTextField(20);
        userText.setBounds(276,178,538,48);
        userText.setFont(new Font("Serif",Font.BOLD,30));

        JPasswordField passText = new JPasswordField(20);
        passText.setBounds(276,247,538,48);
        passText.setFont(new Font("Serif",Font.BOLD,30));

        add(loginLabel);
        add(userLabel);
        add(passLabel);
        add(userText);
        add(passText);
        add(okButton);
        add(backButton);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userValue = userText.getText();
                String passValue = passText.getText();
                boolean status = login.loginAdmin(userValue,passValue);
                if(status){
                    JOptionPane.showMessageDialog(null,"Login Sukses","Message",JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    new AdminMenuFrame();
                }
                else{
                    dispose();
                    new AdminLoginFrame();
                    JOptionPane.showMessageDialog(null,"Login Gagal","Message",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HomePageFrame();
                dispose();
            }
        });
    }
}
