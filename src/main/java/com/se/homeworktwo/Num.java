package com.se.homeworktwo;

import java.util.*;

public class Num {

    int n;
    int at;
    String name;
    Map<String, Integer> _has;

    public Num()
    {
        this(0,"");
    }
    public Num (int col, String name) {
        this.n = 0;
        this._has = new HashMap<>();
        this.name = name;
        this.at = col;
    }

    
}
