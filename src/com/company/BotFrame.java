package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotFrame extends JFrame {

    Bot bot = new Bot();

    JPanel panelBottom = new JPanel();
    JPanel panelMain = new JPanel();

    JLabel labelName = new JLabel("");
    JLabel labelSpace1 = new JLabel("       ");
    JLabel labelSpace2 = new JLabel("       ");

    JTextArea areaChat = new JTextArea(15,45);
    JScrollPane scroll = new JScrollPane(areaChat);
    JTextField textChat = new JTextField(20);
    JButton buttonOk = new JButton("OK");

    protected void chatFrame(){

        setTitle("Поговорим о WOW?");
        setSize(550,360);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        areaChat.setEditable(false);
        areaChat.setLineWrap(true);

        panelBottom.setLayout(new GridBagLayout());
        panelMain.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 0;
        panelBottom.add(labelName, c);
        c.gridx = 1;
        c.gridy = 0;
        panelBottom.add(textChat, c);
        c.gridx = 2;
        c.gridy = 0;
        panelBottom.add(labelSpace1, c);
        c.gridx = 3;
        c.gridy = 0;
        panelBottom.add(buttonOk, c);

        c.gridx = 0;
        c.gridy = 0;
        panelMain.add(scroll, c);
        c.gridx = 0;
        c.gridy = 1;
        panelMain.add(labelSpace2, c);
        c.gridx = 0;
        c.gridy = 2;
        panelMain.add(panelBottom, c);

        add(panelMain);

        buttonOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonAction();
            }
        });

        JRootPane rootPane = SwingUtilities.getRootPane(buttonOk);  //Установка кнопки на Enter (по умолчанию)
        rootPane.setDefaultButton(buttonOk);
        textChat.requestFocusInWindow();  //Фокус на текстфилд
    }

    protected void buttonAction(){
        String stringIn = textChat.getText();

        if (stringIn.trim().length() > 0){  //trim() - удаляет пробелы в начале и конце строки
            areaChat.append(labelName.getText()+stringIn+"\n");  //append - мы сразу добавляем к уже имеющемуся тексту
        }
        textChat.setText("");
        areaChat.append("Бот:   "+bot.botTalk(stringIn)+"\n");  //выводим то, что говорит бот
    }

    public JLabel getLabel(){  //получение лейбла (обрабатывается в LoginForm и Main)
        return labelName;
    }
}
