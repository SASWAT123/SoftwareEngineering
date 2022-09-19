package com.se.homeworktwo;

import java.util.*;

public class Cols {

    Map<Integer, String> names;
    public Map<String, Cell> all;
    public List<String> x;
    public List<String> y;
    String klass;

    public Cols (Map<Integer, String> names) {
        this.names=names;
        all = new HashMap<>();
        x = new ArrayList<>();
        y = new ArrayList<>();
        klass = null;

        for (Map.Entry<Integer, String> e: this.names.entrySet()) {
            String s = e.getValue();
            String col;

            Cell cell;
            if(Character.isUpperCase(s.charAt(0))){
                cell = new Num(e.getKey(), s);
                col = "Num";
            }else{
                cell = new Sym(e.getKey(), s);
                col = "Sym";
            }

            all.put(s,cell);

            if (!s.endsWith(":")) {

                if (s.endsWith("+") || s.endsWith("-")){
                    y.add(s);
                }else{
                    x.add(s);
                }

                if(s.endsWith("!")){
                    klass=col;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Cols{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
