package com.example.application.view;

import com.example.application.infrastructure.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PilotForm extends JFrame{
    private JPanel mainPanel;
    private JLabel roleLabel;
    private JLabel pilotLabel;
    private JLabel userLabel;
    private JTextField exactUserTextField;
    private JLabel informationLabel;
    private JTextField informationTextField;
    private JButton enginesOffButton;
    private JButton readyButton;

    public PilotForm(){
        readyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Client().post();
            }
        });
    }

    public static void open() {
        JFrame frame = new JFrame("PilotForm");
        frame.setContentPane(new PilotForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
