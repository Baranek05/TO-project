package com.example.application.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeneralManagerForm {
    private JPanel mainPanel;
    private JLabel roleLabel;
    private JLabel generalManagerLabel;
    private JLabel userLabel;
    private JTextField exactUserTextField;
    private JLabel sendMessageLabel;
    private JComboBox usersComboBox;
    private JLabel messageLabel;
    private JTextField messageTextField;
    private JButton sendButton;
    private JLabel assignTimeLabel;
    private JTextField timeTextField;
    private JLabel minutesLabel;
    private JLabel toLabel;
    private JButton assignButton;
    private JComboBox usersStandManagersComboBox;

    public GeneralManagerForm(){
        sendButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        assignButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void open() {
        JFrame frame = new JFrame("GeneralManagerForm");
        frame.setContentPane(new GeneralManagerForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
