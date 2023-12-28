package com.example.WitcherPokerAssistant.WitchPocker;

public enum Combinations {
    NOTHING(0,"NOTHING"), //nothing                             101111
    PAIR(1,"PAIR"), //two same value +                          211100
    TWO_PAIRS(2,"TWO_PAIRS"), //two pairs +                     221000
    THREE_OF_A_KIND(3,"THREE_OF_A_KIND"), //three same value +  311000
    FIVE_HIGH_STRAIGHT(4,"FIVE_HIGH_STRAIGHT"), //[1,...,5] +   111110
    SIX_HIGH_STRAIGHT(5,"SIX_HIGHT_STRAIGHT"),//[2,...,6] +     011111
    FULL_HOUSE(6,"FULL_HOUSE"), //pair + three +                320000
    FOUR_OF_A_KIND(7,"FOUR_OF_A_KIND"), //4 same value +        510000
    FIVE_OF_A_KIND(8,"FIVE_OF_A_KIND"); //5 same value +        600000

    private final String stringValue;
    private final int numericValue;

    Combinations(int numericValue, String stringValue) {
        this.numericValue = numericValue;
        this.stringValue = stringValue;
    }
    public int getNumericValue() {
        return numericValue;
    }
    public String getStringValue() {
        return stringValue;
    }
}
