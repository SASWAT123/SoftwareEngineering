package com.se.homeworktwo;

import java.util.*;
import java.lang.Math;

public class Sym
{
    int n;
    int at;
    String name;
    Map<String, Integer> _has;

    public Sym()
    {
        this(0,"");
    }
    public Sym (int col, String name) {
        this.n = 0;
        this._has = new HashMap<>();
        this.name = name;
        this.at = col;
    }

    public void add (String v) {
        if (v == null || v.isEmpty()) {
            return;
        }
        else if (_has.containsKey(v)) {
            _has.put(v, _has.get(v) + 1);
        } else {
            _has.put(v, 1);
        }
        n++;
    }

    public String mid() {
        int most = -1;
        int v;
        String mode = "";
        for (String key : _has.keySet()) {
            v = _has.get(key);
            if (v > most) {
                most = v;
                mode = key;
            }
        }
        return mode;
    }

    public double unit_entropy(double unit) {
        return unit*Math.log(unit)/Math.log(2);
    }

    public double div(){
        double e = 0;
        for (String key : _has.keySet()) {
           double freq = _has.get(key);
           e -= unit_entropy(freq/n);
        }
        return e;
    }
}