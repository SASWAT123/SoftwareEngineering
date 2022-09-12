package com.se.homeworktwo;
import java.util.*;

import javax.lang.model.util.ElementScanner14;

public class Cols {

    Map<Integer, String> names;
    public ArrayList<String> all;
    public ArrayList<String> x;
    public ArrayList<String> y;
    String klass;

    public Cols (Map<Integer, String> names) {
        this.names=names;
        this.all = new ArrayList<String>();
        this.x = new ArrayList<String>();
        this.y = new ArrayList<String>();
        klass=null;
        for (int c : this.names.keySet()) 
        {
            String s = this.names.get(c);
            //String col;
            all.add(s);
            if (!s.endsWith(":"))
            {
                if (s.endsWith("+") || s.endsWith("-"))
                    y.add(s);
                else
                    x.add(s);
                
            }

        }    
}
}
