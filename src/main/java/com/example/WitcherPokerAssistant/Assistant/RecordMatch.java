package com.example.WitcherPokerAssistant.Assistant;


public class RecordMatch{
    int id;
    float prediction;
    String result;
    public RecordMatch(int id, float prediction, String result){
        this.id = id;
        this.prediction = prediction;
        this.result = result;
    }

    public int getId() {
        return id;
    }

    public float getPrediction() {
        return prediction;
    }

    public String getResult() {
        return result;
    }
}
