package com.example.WitcherPokerAssistant.WitchPocker;

public class WitchMain {
    public static void main(String[] args) {
        Hand hand = new Hand();
        int[] scores = new int[9];
        int N = 1_000_000;
        for (int i = 0; i<N; i++){
            Combinations combi =WitcherGame.check(hand);
            scores[combi.getNumericValue()] += 1;
            hand.roll();
            //System.out.println(hand.toString());
        }
        float[] arr = new float[9];
        for(int i=0;i<9;i++){
            System.out.println(scores[i]/(float)N);
            for (int j=i;j<9;j++){
                arr[j] += scores[i]/(float)N;
            }
        }
        for(int i=0;i<9;i++){
            System.out.print(arr[i]);
            System.out.print(", ");

        }

    }
}

