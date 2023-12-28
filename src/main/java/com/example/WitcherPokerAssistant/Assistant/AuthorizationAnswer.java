package com.example.WitcherPokerAssistant.Assistant;

public class AuthorizationAnswer {
    boolean isRight;
    int playerId;
    public AuthorizationAnswer(boolean isRight, int playerId){
        this.isRight = isRight;
        this.playerId = playerId;
    }

    public boolean isRight() {
        return isRight;
    }

    public int getPlayerId() {
        return playerId;
    }
}
