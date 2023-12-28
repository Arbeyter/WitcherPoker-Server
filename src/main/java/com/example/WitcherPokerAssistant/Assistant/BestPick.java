package com.example.WitcherPokerAssistant.Assistant;

import com.example.WitcherPokerAssistant.WitchPocker.Hand;
import com.example.WitcherPokerAssistant.WitchPocker.Oracle;

import java.util.Random;

public class BestPick {
    int[] set;
    float probability;
    Hand player;
    Hand enemy;
    Random random;
    public BestPick(Step step){
        player = new Hand(step.getDropValuesPlayer());
        enemy = new Hand(step.getDropValuesEnemy());
        random = new Random();
    }
    public void calculate(){
//        for (int i=0;i<5;i++){
//            set[i]=random.nextInt(0,999)%2;
//        }
        set = Oracle.whichRoll(player,enemy);
    }
    public int[] getSet() {
        calculate();
        return set;
    }

    public float getProbability() {
        probability = Oracle.predictPrestige(player,enemy);
        return probability;
    }

    public void setProbability(float probability) {
        this.probability = probability;
    }

    public void setSet(int[] set) {
        this.set = set;
    }
}
