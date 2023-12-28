package com.example.WitcherPokerAssistant.Assistant;

public class End {
    int idGame;
    float predictResult;
    boolean realResult;
    public End(){}
    public End(int idGame, float predictResult, boolean realResult){
        this.idGame = idGame;
        this.predictResult = predictResult;
        this.realResult = realResult;
    }

    public int getIdGame() {
        return idGame;
    }

    public boolean getRealResult() {
        return realResult;
    }

    public float getPredictResult() {
        return predictResult;
    }
}
