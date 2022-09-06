package com.se.homeworktwo;

import java.util.Map;
import java.lang.Math;

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

    void add(String v) {
        if (_has.containsKey(v)) {
            _has.put(v, _has.get(v) + 1);
        } else {
            _has.put(v, 1);
        }
        n++;
    }

    String mid() {
        int most = -1;
        int v;
        String mode = "";
        for(String key : _has.keySet()) {
            v = _has.get(key);
            if (v > most) {
                most = v;
                mode = key;
            }
        }
        return mode;
    }

    double unit_entropy(double unit) {
        return unit*Math.log(unit)/Math.log(2);
    }

    double div(){
        double e = 0;
        for(String key : _has.keySet()) {
           e -= unit_entropy(_has.get(key)/n);
        }
        return e;
    }
}