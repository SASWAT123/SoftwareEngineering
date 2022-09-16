package com.se.homeworktwo;

import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.util.*;

public class Data {
    public Cols cols;
    ArrayList<Row> rows;

    public Data(Object src) throws IOException, CsvException {
        cols = null;
        rows = new ArrayList<>();
        if(src instanceof String){
            List<String[]> csvData = App.csv((String) src);
            for(int i=0;i<csvData.size();i++){
                add(csvData.get(i));
            }
        } else if(src instanceof Map){
//            for(Object a: ((Map) src).values()){
//                add(a);
//            }
        }
    }

    public void add(String[] a){
        if(cols == null){
            Map<Integer, String> colNamesMap = new LinkedHashMap<>();
            for(int i=0;i<a.length;i++){
                colNamesMap.put(i, a[i]);
            }
            cols = new Cols(colNamesMap);
        } else {
            ArrayList<String> list = new ArrayList<>(Arrays.asList(a));
            Row row = new Row(list);
            rows.add(row);
        }
    }

    // TODO: Add logic for stats
    public Map<String, Double> stats() {
        Map<String, Double> statistics = null;
        return statistics;
    }
}
