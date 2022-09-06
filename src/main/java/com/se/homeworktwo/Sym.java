package com.se.homeworktwo;

import java.util.Map;

public class Sym
{
    int n;
    int at;
    String name;
    Map<String, Integer> _has;

    public Sym(int col, String name) {
        this.n = 0;
        this._has.clear();
        this.name = name;
        this.at = col;
    }
}