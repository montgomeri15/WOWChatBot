package com.company;

import com.company.DB.DbManager;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        BotFrame botFrame = new BotFrame();
        botFrame.chatFrame();

        LoginForm loginForm = new LoginForm();
        loginForm.loginForm(botFrame.getLabel());

        DbManager dbManager = new DbManager();
        try {
            dbManager.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
