package com.se.homeworktwo;

import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.util.*;

import static java.lang.String.valueOf;

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
            for(Object a: ((Map) src).values()){
                add((String[]) a);
            }
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
            for(int i=0; i<a.length ;i++){
                if(a[i] == "?")
                    continue;
                Cell cell = cols.all.get(i);
                if(cell instanceof Num){
                    ((Num) cell).add(Integer.parseInt(a[i]));
                }
                else if(cell instanceof Sym){
                    ((Sym) cell).add(a[i]);
                }
            }
        }
    }

    public Map<String, String> stats(int places,List<String> showCols, String fun) {
        Map<String, String> statistics = null;
        switch (fun){
            case "div":
                for(String a: showCols){
                    Object ans = cols.all.get(a);
                    if(ans instanceof Num){
                        statistics.put(a, valueOf(rnd(((Num) ans).div(), places)));
                    }
                    else
                        statistics.put(a, valueOf(((Sym) ans).div()));
                };
                break;
            case "mid":
                for(String a: showCols){
                    Object ans = cols.all.get(a);
                    if(ans instanceof Num){
                        statistics.put(a, valueOf(rnd(((Num) ans).mid(), places)));
                    }
                    else
                        statistics.put(a, valueOf(((Sym) ans).mid()));
                };
                break;
        }

        return statistics;
    }

    private double rnd(double x, Integer places) {
        double mult = Math.pow(10, places);
        return Math.floor(x * mult + 0.5) / mult;
    }
}
