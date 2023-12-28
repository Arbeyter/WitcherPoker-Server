package com.example.WitcherPokerAssistant.WitchPocker;

public class Hand {
    Dice[] listDices;
    int[] dropValues;
    int[] vectorValues;
    int countNumber;
    Combinations combination;
    public Hand(){
        countNumber = 5;
        listDices = new Dice[countNumber];
        dropValues = new int[countNumber];
        for (int i=0; i<countNumber;i++){
            listDices[i] = new Dice();
            dropValues[i] = listDices[i].roll();
        }
        combination = WitcherGame.check(this);
        getVector();
    }
    public Hand(int[] dropValues){
        countNumber = 5;
        listDices = new Dice[countNumber];
        this.dropValues = new int[countNumber];
        for (int i=0; i<countNumber;i++){
            listDices[i] = new Dice();
            this.dropValues[i] = dropValues[i];
        }
        combination = WitcherGame.check(this);
        getVector();
    }
    public void roll(){
        for (int i=0; i<countNumber; i++){
            listDices[i].roll();
            dropValues[i] = listDices[i].getDropValue();
        }
        combination = WitcherGame.check(this);
    }
    public void roll(int maskForRoll){
        for (int i=0; i<countNumber; i++){
            if (maskForRoll%2 == 1){
                listDices[i].roll();
            }
            maskForRoll /= 2;
        }
        combination = WitcherGame.check(this);
    }

    public void setDropValues(int[] dropValues) {
        if (dropValues.length == 5){
            this.dropValues = dropValues;
            getVector();
        }
        else {
            this.vectorValues = dropValues;
            for (int i=0; i<6; i++){
                this.dropValues[i] += dropValues[i];
            }
        }

    }

    public int[] getDropValues() {
        return dropValues;
    }
    private int getCount(int value){
        int count =0 ;
        for (int i=0; i<5; i++){
            if (dropValues[i] == value) count++;
        }
        return count;
    }
    public int[] getVector(){
        vectorValues = new int[6];
        for (int i=0; i<6; i++){
            vectorValues[i] = getCount(i+1);
        }
        return vectorValues;
    }
    public String toString(){
        StringBuilder drops = new StringBuilder(5);
        for (int i=0; i<5; i++){
            drops.append(dropValues[i]);
        }
        drops.append(" : ");
        int[] arr = getVector();
        for (int i=0; i<6; i++){
            drops.append(arr[i]);
        }
        return drops.toString();
    }
}
