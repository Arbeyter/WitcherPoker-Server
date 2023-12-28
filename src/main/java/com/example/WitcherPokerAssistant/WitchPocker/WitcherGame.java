package com.example.WitcherPokerAssistant.WitchPocker;

public class WitcherGame {
    Hand player1;
    Hand player2;

    public static boolean isFive(Hand hand){
        int[] arr = hand.getVector();
        for (int i =0; i<6; i++){
            if (5 == arr[i]){
                return true;
            }
        }
        return false;
    }
    public static boolean isFour(Hand hand){
        int[] arr = hand.getVector();
        for (int i =0; i<6; i++){
            if (4 == arr[i]){
                return true;
            }
        }
        return false;
    }
    public static boolean isFullHouse(Hand hand){
        int[] arr = hand.getVector();
        if (isPair(hand) && isThree(hand)){
            return true;
        }
        return false;
    }
    public static boolean isPair(Hand hand){
        int[] arr = hand.getVector();
        boolean flag = false;
        for (int i =0; i<6; i++){
            if (2 == arr[i]){
                return true;
            }
        }
        return false;
    }
    public static boolean isThree(Hand hand){
        int[] arr = hand.getVector();
        boolean flag = false;
        for (int i =0; i<6; i++){
            if (3 == arr[i]){
                return true;
            }
        }
        return false;
    }
    public static boolean isTwoPair(Hand hand){
        int[] arr = hand.getVector();
        boolean flag = false;
        for (int i =0; i<6; i++){
            if (2 == arr[i]){
                if (flag){
                    return true;
                }
                else{
                    flag = true;
                }
            }
        }
        return false;
    }
    public static boolean isFiveStraight(Hand hand){
        int[] arr = hand.getVector();
        boolean flag = true;
        for (int i =0; i<5; i++){
            if (1 == arr[i]){
                flag &= true;
                }
            else{
                flag&= false;
            }
        }
        return flag;
    }
    public static boolean isSixStraight(Hand hand){
        int[] arr = hand.getVector();
        boolean flag = true;
        for (int i =1; i<6; i++){
            if (1 == arr[i]){
                flag &= true;
            }
            else{
                flag&= false;
            }
        }
        return flag;
    }
    public static Combinations check(Hand hand){
        if (isFive(hand)) return Combinations.FIVE_OF_A_KIND;
        if (isFour(hand)) return Combinations.FOUR_OF_A_KIND;
        if (isFullHouse(hand)) return Combinations.FULL_HOUSE;
        if (isSixStraight(hand)) return Combinations.SIX_HIGH_STRAIGHT;
        if (isFiveStraight(hand)) return Combinations.FIVE_HIGH_STRAIGHT;
        if (isThree(hand)) return Combinations.THREE_OF_A_KIND;
        if (isTwoPair(hand)) return Combinations.TWO_PAIRS;
        if (isPair(hand)) return Combinations.PAIR;
        return Combinations.NOTHING;
    }
}
