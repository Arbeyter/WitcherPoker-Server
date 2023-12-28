package com.example.WitcherPokerAssistant.WitchPocker;

import java.util.Random;

public class Dice {
    private int dropValue;
    private int d; // edge of dice; d6 d24 etc
    private Random random;

    public Dice(int d) {
        this.d = d;
        random = new Random();
    }

    public Dice() {
        this.d = 6;
        random = new Random();
    }

    public int getD() {
        return d;
    }

    public int getDropValue() {
        return dropValue;
    }

    public int roll() {
        dropValue = random.nextInt(1, d+1);
        return dropValue;
    }

}
