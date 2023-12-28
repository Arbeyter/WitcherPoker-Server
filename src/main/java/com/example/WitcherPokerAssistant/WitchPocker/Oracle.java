package com.example.WitcherPokerAssistant.WitchPocker;

import java.util.Arrays;

public class Oracle {
    //masks = [bin(a|32)[3:] for a in range(32)]
    static float[] predicts = {0.06287f, 0.52416f, 0.75524f, 0.91049004f, 0.92577004f, 0.94131005f, 0.98035f, 0.99932003f, 1.0f };
    public static float predictPrestige(Hand player, Hand enemy){
        int[] vector1 = player.getVector();
        int[] vector2 = enemy.getVector();
        int value_combination1 = player.combination.getNumericValue();
        int value_combination2 = enemy.combination.getNumericValue();
        int sum1 = Arrays.stream(player.getDropValues()).sum();
        int sum2 = Arrays.stream(enemy.getDropValues()).sum();

        if (value_combination1 > value_combination2 &&  (sum1> sum2)){
            return 1.0f;
        }
        int pointsPlayer =1;
        int pointsEnemy = 1;
        for (int i=0; i<5; i++){
            pointsPlayer *= vector1[i] != 0 ? vector1[i] : 1;
            pointsEnemy *= vector2[i] != 0 ? vector2[i] : 1;
        }
        float probability;
        if (sum1 != sum2)
            probability = (float) Math.exp(Math.min(pointsPlayer - pointsEnemy, pointsEnemy - pointsPlayer));
        else
            probability = 1 - (sum2-sum1)/36;
        return probability;
    }
    public static int[] whichRoll(Hand player, Hand enemy){
        int[] vector = player.getVector();
        int[] dropValues = player.getDropValues();
        int[] mask = {0,0,0,0,0};
        if (predictPrestige(player,enemy) == 1) return mask;
        for (int i=0; i<6; i++){
            if (vector[i] == 1){
                for (int j=0; j<5;j++){
                    if(dropValues[j]-1 == i) {
                        mask[j] = 1;
                    }
                }

            }
        }
        return mask;
    }
}
