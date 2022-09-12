package com.se.homeworktwo;
import java.util.*;

public class Cols {

    Map<String, String> names;
    public ArrayList<String> all;
    public ArrayList<String> x;
    public ArrayList<String> y;
    String klass;

    public Cols (Map<String, String> names) {
        this.names=names;
        this.all = new ArrayList<String>();
        this.x = new ArrayList<String>();
        this.y = new ArrayList<String>();
        klass=null;
    }

    
}
