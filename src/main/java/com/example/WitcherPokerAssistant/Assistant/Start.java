package com.example.WitcherPokerAssistant.Assistant;

public class Start {
    int playerId;
    public Start(){
        this.playerId = 0;
    }
    public Start(int playerId){
        this.playerId = playerId;
    }

    public int getPlayerId() {
        return playerId;
    }
    public void setPlayerId(int playerId){
        this.playerId = playerId;
    }
}
