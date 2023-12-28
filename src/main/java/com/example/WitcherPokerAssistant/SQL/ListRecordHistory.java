package com.example.WitcherPokerAssistant.SQL;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListRecordHistory implements Serializable {
    List<RecordHistory> recordHistories;
    public ListRecordHistory(){
        recordHistories = new ArrayList<RecordHistory>();
    }
    public List<RecordHistory> getRecordHistories() {
        return recordHistories;
    }
    public void add(RecordHistory recordHistory){
        recordHistories.add(recordHistory);
    }
    public void add(int number, float predict, boolean result){
        recordHistories.add(new RecordHistory(number, predict, result));
    }
}