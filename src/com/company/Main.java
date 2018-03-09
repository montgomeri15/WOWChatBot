package com.company;

public class Main {

    public static void main(String[] args) {
        BotFrame botFrame = new BotFrame();
        botFrame.chatFrame();

        LoginForm loginForm = new LoginForm();
        loginForm.loginForm(botFrame.getLabel());
    }
}
