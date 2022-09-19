package com.se.homeworktwo;

import java.util.*;

public class Cols {

    Map<Integer, String> names;
    public Map<Integer, Cell> all;
    public List<Integer> x;
    public List<Integer> y;
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

            all.put(col_num,cell);

            if (!s.endsWith(":")) {

                if (s.endsWith("+") || s.endsWith("-")){
                    y.add(col_num);
                }else{
                    x.add(col_num);
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
