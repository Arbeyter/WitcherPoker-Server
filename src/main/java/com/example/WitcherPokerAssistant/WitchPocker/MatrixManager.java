package com.example.WitcherPokerAssistant.WitchPocker;

import com.example.WitcherPokerAssistant.SQL.SQL;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

import java.io.IOException;
import java.io.InputStream;

public class MatrixManager {
    private float[][][] matrix;
    public MatrixManager(){

    }
    public float getValue(int maskForPick, int startValueDices, int finishState){
        return matrix[maskForPick][startValueDices][finishState];
    }
    private void readeJSON(){
        InputStream inputStream = MatrixManager.class.getClassLoader().getResourceAsStream("matrix.json");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Matrix matrix = objectMapper.readValue(inputStream, Matrix.class);
            this.matrix = matrix.getMatrix();;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
