package com.example.WitcherPokerAssistant.Assistant;

public class Authorization {
    String login;
    String password;
    public Authorization(String login, String password){
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
