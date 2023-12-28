package com.example.WitcherPokerAssistant.SQL;

import java.io.Serializable;

public class RecordHistory implements Serializable {
    int number;
    float predict;
    boolean result;
    public RecordHistory(int number, float predict, boolean result){
        this.number = number;
        this.predict = predict;
        this.result = result;
    }

    public int getNumber() {
        return number;
    }

    public float getPredict() {
        return predict;
    }

    public boolean isResult() {
        return result;
    }
}