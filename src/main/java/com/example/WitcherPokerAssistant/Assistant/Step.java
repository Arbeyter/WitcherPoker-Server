package com.example.WitcherPokerAssistant.Assistant;

public class Step {
    //boolean whoseTurn;
    int idGame;
    int[] dropValuesPlayer;
    int[] dropValuesEnemy;
    //boolean isLastMove;
    public Step(){
        //whoseTurn = true;
        dropValuesPlayer = new int[5];
        dropValuesEnemy = new int[5];
        //isLastMove = true;
    }

    public int[] getDropValuesPlayer() {
        return dropValuesPlayer;
    }
    public int[] getDropValuesEnemy(){
        return  dropValuesEnemy;
    }

    public int getIdGame() {
        return idGame;
    }
}
