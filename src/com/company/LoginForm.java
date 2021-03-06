package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame{

    JPanel panel = new JPanel();
    JLabel labelLogin = new JLabel("Представьтесь:");
    JLabel labelSpace1 = new JLabel("       ");
    JLabel labelSpace2 = new JLabel("       ");
    JTextField textField = new JTextField(15);
    JButton button = new JButton("ОК");

    BotFrame botFrame = new BotFrame();

    protected void loginForm(final JLabel ourLabel){

        setTitle("Логин");
        setSize(250,150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 0;
        panel.add(labelLogin, c);
        c.gridx = 0;
        c.gridy = 1;
        panel.add(labelSpace1, c);
        c.gridx = 0;
        c.gridy = 2;
        panel.add(textField, c);
        c.gridx = 0;
        c.gridy = 3;
        panel.add(labelSpace2, c);
        c.gridx = 0;
        c.gridy = 4;
        panel.add(button, c);

        add(panel);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ourLabel.setText(textField.getText()+":   ");  //отправление значения в лейбл (обрабатывается в Main)
                //botFrame.chatFrame();
                setVisible(false);
            }
        });

        JRootPane rootPane = SwingUtilities.getRootPane(button);  //Установка кнопки на Enter (по умолчанию)
        rootPane.setDefaultButton(button);
        textField.requestFocusInWindow();  //Фокус на текстфилд
    }
}
