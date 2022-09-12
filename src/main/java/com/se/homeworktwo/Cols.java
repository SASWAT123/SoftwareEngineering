package com.se.homeworktwo;

import java.util.*;

public class Cols {

    Map<Integer, String> names;
    public ArrayList<String> all;
    public ArrayList<String> x;
    public ArrayList<String> y;
    String klass;

    public Cols (Map<Integer, String> names) {
        this.names=names;
        all = new ArrayList<String>();
        x = new ArrayList<String>();
        y = new ArrayList<String>();
        klass=null;
        for (int c : this.names.keySet()) 
        {
            String s = this.names.get(c);
            String col;
            //Check logic for local col
            if(Character.isUpperCase(s.charAt(0)))
                col="Num";
            else
                col="Sym";
            all.add(s);
            if (!s.endsWith(":"))
            {
                if (s.endsWith("+") || s.endsWith("-"))
                    y.add(s);
                else
                    x.add(s);
                if(s.endsWith("!"))
                    klass=col;
                
            }

        }    
}
}
