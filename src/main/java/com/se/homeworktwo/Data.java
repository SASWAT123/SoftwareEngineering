package com.se.homeworktwo;

import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class Data {
    Cols cols;
    ArrayList<Row> rows;

    public Data(Object src) throws IOException, CsvException {
        cols = null;
        rows = new ArrayList<>();
        if(src instanceof String){
            App.readCSV((String) src);
        }
        else if(src instanceof Map){
            for(Object a: ((Map) src).values()){
                add(a);
            }
        }
    }

    // TODO: Correct data types for Cols and Row
    public void add(Object a){
        if(cols == null)
            cols = new Cols((Map<Integer, String>) a);
        else {
            Row row = new Row((ArrayList<Double>) a);
            // Need to add the for loop
        }
    }

    // TODO: Add logic for stats
    public Map<String, Double> stats() {
        Map<String, Double> statistics = null;
        return statistics;
    }
}
