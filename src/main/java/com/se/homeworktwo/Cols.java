package com.se.homeworktwo;

import java.util.*;

public class Cols {

    Map<Integer, String> names;
    public Map<String, String> all;
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

            if(Character.isUpperCase(s.charAt(0))){
                col="Num";
            }else{
                col="Sym";
            }

            all.put(s,col);

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
