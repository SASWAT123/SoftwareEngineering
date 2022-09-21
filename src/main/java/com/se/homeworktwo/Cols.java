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
            int col_num=e.getKey();
            String col;

            Cell cell;
            if(Character.isUpperCase(s.charAt(0))){
                cell = new Num(col_num, s);
                col = "Num";
            }else{
                cell = new Sym(col_num, s);
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
                "names=" + names +
                ", all=" + all +
                ", x=" + x +
                ", y=" + y +
                ", klass='" + klass + '\'' +
                '}';
    }
}
